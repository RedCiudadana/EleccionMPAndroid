package eleccionmp.redciudadana.org.eleccionmp

import android.app.Application
import com.twitter.sdk.android.core.Twitter

/**
 * Created by javier on 2/2/18.
 */

class MPApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Twitter.initialize(this)
    }
}