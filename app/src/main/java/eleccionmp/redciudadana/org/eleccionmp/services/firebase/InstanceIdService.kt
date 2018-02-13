package eleccionmp.redciudadana.org.eleccionmp.services.firebase

import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

/**
 * Created by javier on 2/6/18.
 */

class InstanceIdService: FirebaseInstanceIdService() {
    override fun onTokenRefresh() {
        super.onTokenRefresh()
        val token = FirebaseInstanceId.getInstance().token
        print("Firebase token: ${token}")
    }
}