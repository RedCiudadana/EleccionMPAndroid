package eleccionmp.redciudadana.org.eleccionmp.views.commissionPerson

import eleccionmp.redciudadana.org.eleccionmp.http.Models
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.IPresenter
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.IView

/**
 * Created by javier on 2/2/18.
 */

object CommissionPersonContract {
    interface View: IView {
        fun showPerson(profile: Models.Profile)
        fun setTitle(title: String)
    }

    interface Presenter: IPresenter<View> {

    }
}