package y2k.android.common

import android.os.Handler
import android.os.Looper

fun timeout(delay: Long, f: () -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed(f, delay)
}
