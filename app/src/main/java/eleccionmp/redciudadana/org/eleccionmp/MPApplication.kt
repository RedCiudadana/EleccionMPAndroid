package eleccionmp.redciudadana.org.eleccionmp

import android.app.Application
import android.util.Log
import com.onesignal.OneSignal
import com.twitter.sdk.android.core.Twitter

/**
 * Created by javier on 2/2/18.
 */

class MPApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Twitter.initialize(this)
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init()
        OneSignal.idsAvailable { userId, registrationId ->
            Log.d("OneSignal", "User id: ${userId}. Registration id: ${registrationId}")
        }
    }
}