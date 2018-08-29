package ikigaiworks.feedrss.application

import android.app.Application
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper

/**
 * Created by hirenpatel on 05/10/17.
 */

class MyApplication : Application() {
    private var mMainThreadHandler: Handler? = null
    private var mBackgroundHandler: Handler? = null

    override fun onCreate() {
        super.onCreate()
        mApp = this
        mMainThreadHandler = Handler(Looper.getMainLooper())
        val bgThread = HandlerThread("ViewModelBackground")
        bgThread.start()
        mBackgroundHandler = Handler(bgThread.looper)
    }

    companion object {

        private var mApp: MyApplication? = null

        fun runOnUiThread(r: Runnable) {
            mApp?.mMainThreadHandler!!.post(r)
        }

        fun runInBackground(r: Runnable) {
            mApp?.mBackgroundHandler!!.post(r)
        }
    }
}
