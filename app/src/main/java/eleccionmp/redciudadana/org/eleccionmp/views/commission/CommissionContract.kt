package eleccionmp.redciudadana.org.eleccionmp.views.commission

import eleccionmp.redciudadana.org.eleccionmp.http.Models
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.IPresenter
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.IView

/**
 * Created by javier on 2/1/18.
 */

object CommissionContract {
    interface View: IView {
        fun showCommissionList(list: List<Models.Profile>)
        fun showCommisionPerson(profile: Models.Profile)
        fun onCommissionPersonSelected(profile: Models.Profile)
    }

    interface Presenter: IPresenter<View> {
        fun onCommissionPersonSelected(profile: Models.Profile)
    }
}