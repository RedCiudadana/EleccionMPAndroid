package eleccionmp.redciudadana.org.eleccionmp.views.candidates

import eleccionmp.redciudadana.org.eleccionmp.http.Profile
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.BasePresenter
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.IPresenter
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.IView

/**
 * Created by javier on 1/24/18.
 */

object CandidatesContract {
    interface View: IView {
        fun showCandidatesList(list: List<Profile>)
        fun setTitle()
    }

    interface Presenter: IPresenter<View> {

    }
}