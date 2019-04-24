package y2k.android.remote

import android.os.AsyncTask
import fi.iki.elonen.NanoHTTPD

class RemoteServer {

    fun start() {
        AsyncTask.THREAD_POOL_EXECUTOR.execute {
            val app = App()
            app.start()
        }
    }
}

private class App : NanoHTTPD(8080) {

    override fun serve(session: IHTTPSession): Response {
        val parms = session.parms
        var msg = "<html><body><h1>Hello server</h1>\n"
        msg += if (parms["username"] == null) {
            "<form action='?' method='get'>\n  <p>Your name: <input type='text' name='username'></p>\n" + "</form>\n"
        } else {
            "<p>Hello, " + parms["username"] + "!</p>"
        }
        return newFixedLengthResponse("$msg</body></html>\n")
    }
}
