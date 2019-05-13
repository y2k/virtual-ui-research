package y2k.virtual.ui.remote

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import fi.iki.elonen.NanoHTTPD
import y2k.virtual.ui.*
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.TimeUnit

object HotReloadServer {

    private val uiHandler by lazy { Handler(Looper.getMainLooper()) }

    fun start(hostView: VirtualHostView): Closeable {
        val nanoHTTPD = mkServer { node ->
            Toast.makeText(hostView.context, "UI updated", Toast.LENGTH_SHORT).show()
            hostView.update(mkNode {
                frameLayout {
                    children += node
                }
            })
        }

        nanoHTTPD.start()

        return Closeable { nanoHTTPD.stop() }
    }

    private fun mkServer(update: (VirtualNode) -> Unit): NanoHTTPD =
        object : NanoHTTPD(8080) {

            override fun serve(session: IHTTPSession): Response {
                return if (Method.PUT == session.method || Method.POST == session.method) {
                    println("LOGX :: POST/PUT | " + session.headers)

                    val len = session.headers["content-length"]!!.toInt()
                    val buf = ByteArray(len)

                    var count = 0
                    while (count < len) {
                        count += session.inputStream.read(buf, count, len - count)
                    }

                    val v = ObjectInputStream(ByteArrayInputStream(buf)).readObject() as VirtualNode
                    println(v)

                    uiHandler.post {
                        update(v)
                    }

                    newFixedLengthResponse(Response.Status.NO_CONTENT, MIME_PLAINTEXT, "")
                } else {
                    println("LOGX :: GET")

                    var msg = "<html><body><h1>Test Server</h1>\n"
                    msg += "<p>TODO</p>"
                    newFixedLengthResponse("$msg</body></html>\n")
                }
            }
        }
}

object HotReloadClient {

    fun send(f: () -> VirtualNode) {
        runInRemote {
            val virtualNode = f()
            sendNode(virtualNode)
        }
    }

    private fun sendNode(virtualNode: VirtualNode) {
        val bytes = toBytes(virtualNode)

        val urlString = "http://${getIp()}:8080/"

        val url = URL(urlString)
        val connection = url.openConnection() as HttpURLConnection
        connection.doInput = true
        connection.doOutput = true
        connection.requestMethod = "PUT"
        connection.setRequestProperty("Content-Type", "application/octet-stream")
        connection.connect()

        connection.outputStream.use { it.write(bytes) }
        connection.inputStream.buffered().readBytes()
    }

    private fun toBytes(node: VirtualNode): ByteArray {
        val stream = ByteArrayOutputStream()
        ObjectOutputStream(stream).writeObject(node)
        return stream.toByteArray()
    }

    @SuppressLint("NewApi")
    private fun getIp(): String {
        val dir = System.getenv("ANDROID_HOME")
        val p = Runtime.getRuntime().exec("$dir/platform-tools/adb shell ifconfig wlan0")
        p.waitFor(5, TimeUnit.SECONDS)
        val response = String(p.inputStream.readBytes())
        return Regex("inet addr:([\\d.]+)").find(response)!!.groupValues[1]
    }
}
