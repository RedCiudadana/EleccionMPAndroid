package eleccionmp.redciudadana.org.eleccionmp.views.commission

import eleccionmp.redciudadana.org.eleccionmp.R
import eleccionmp.redciudadana.org.eleccionmp.http.Models
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.BasePresenter
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.IPresenter

/**
 * Created by javier on 2/1/18.
 */

class CommissionPresenter: BasePresenter<CommissionContract.View>(), CommissionContract.Presenter {

    override fun onViewCreated() {
        mView?.setTitle()
        mView?.showLoading()
        Models.getCommission { list, throwable ->
            if (throwable != null) {
                mView?.showError(R.string.errors_could_not_load)
            } else {
                mView?.hideLoading()
                mView?.showCommissionList(list!!)
            }
        }
    }


    override fun onCommissionPersonSelected(profile: Models.Profile) {
        mView?.showCommisionPerson(profile)
    }

}