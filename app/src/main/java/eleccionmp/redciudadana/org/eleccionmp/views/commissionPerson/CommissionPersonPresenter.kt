package eleccionmp.redciudadana.org.eleccionmp.views.commissionPerson

import eleccionmp.redciudadana.org.eleccionmp.http.Models
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.BasePresenter

/**
 * Created by javier on 2/2/18.
 */

class CommissionPersonPresenter: BasePresenter<CommissionPersonContract.View>(), CommissionPersonContract.Presenter {
    override fun onViewCreated() {
        val args = mView?.getArguments()
        val profile: Models.Profile? = args?.getParcelable("profile")
        if (profile != null) {
            mView?.showPerson(profile)
            if (profile.nombre != null){
                mView?.setTitle(profile.nombre)
            }
        }
    }

}