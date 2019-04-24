package y2k.android

import org.junit.Assert
import org.junit.Test
import java.util.concurrent.TimeUnit

class RemoteDslExampleActivityTest {

    @Test
    fun run() {
        val remote = Remote()
        Assert.assertEquals("10.5.100.179", remote.getIp())
    }
}

class Remote {

    fun getIp(): String {
        val dir = System.getenv("ANDROID_HOME")
        val p = Runtime.getRuntime().exec("$dir/platform-tools/adb shell ifconfig wlan0")
        p.waitFor(5, TimeUnit.SECONDS)
        val response = p.inputStream.readBytes().let { String(it) }
        return Regex("inet addr:([\\d.]+)").find(response)!!.groupValues[1]
    }
}
