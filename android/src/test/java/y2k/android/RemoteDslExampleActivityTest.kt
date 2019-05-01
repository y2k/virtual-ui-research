package y2k.android

import org.junit.Test
import y2k.virtual.ui.VirtualNode
import y2k.virtual.ui.runInRemote
import java.io.ByteArrayOutputStream
import java.io.ObjectOutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.TimeUnit

class RemoteDslExampleActivityTest {

    @Test
    fun run() {
        runInRemote {
            val virtualNode = DslExampleActivity.makeStage(null, 0) {}
            Remote.send(virtualNode)
        }
    }
}

object Remote {

    fun send(virtualNode: VirtualNode) {
        val bytes = toBytes(virtualNode)

        val urlString = "http://${getIp()}:8080/"
        println(urlString)

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

    private fun getIp(): String {
        val dir = System.getenv("ANDROID_HOME")
        val p = Runtime.getRuntime().exec("$dir/platform-tools/adb shell ifconfig wlan0")
        p.waitFor(5, TimeUnit.SECONDS)
        val response = p.inputStream.readBytes().let { String(it) }
        return Regex("inet addr:([\\d.]+)").find(response)!!.groupValues[1]
    }
}
