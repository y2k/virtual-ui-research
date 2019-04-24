package y2k.android.remote

import android.os.AsyncTask
import android.os.Handler
import android.os.Looper
import fi.iki.elonen.NanoHTTPD
import y2k.virtual.ui.VirtualNode
import java.io.ByteArrayInputStream
import java.io.ObjectInputStream

class RemoteServer(private val f: (VirtualNode) -> Unit) {

    private val handler = Handler(Looper.getMainLooper())

    fun start() {
        AsyncTask.THREAD_POOL_EXECUTOR.execute {
            object : NanoHTTPD(8080) {

                override fun serve(session: IHTTPSession): Response {
                    return if (Method.PUT == session.method || Method.POST == session.method) {
                        println("LOGX :: POST/PUT | " + session.headers)

                        val len = session.headers["content-length"]!!.toInt()
                        val buf = ByteArray(len)

                        val readed = session.inputStream.read(buf)
                        assert(len == readed) { "$readed / $len" }

                        val v = ObjectInputStream(ByteArrayInputStream(buf)).readObject() as VirtualNode
                        println(v)

                        handler.post {
                            f(v)
                        }

                        newFixedLengthResponse(Response.Status.NO_CONTENT, MIME_PLAINTEXT, "")
                    } else {
                        println("LOGX :: GET")

                        var msg = "<html><body><h1>Test Server</h1>\n"
                        msg += "<p>TODO</p>"
                        newFixedLengthResponse("$msg</body></html>\n")
                    }
                }
            }.start()
        }
    }
}
