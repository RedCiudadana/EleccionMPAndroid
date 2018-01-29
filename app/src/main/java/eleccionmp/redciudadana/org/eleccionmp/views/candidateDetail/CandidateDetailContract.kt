package eleccionmp.redciudadana.org.eleccionmp.views.candidateDetail

import eleccionmp.redciudadana.org.eleccionmp.http.Profile
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.IPresenter
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.IView

/**
 * Created by javier on 1/28/18.
 */

object CandidateDetailContract {
    interface View: IView {
        fun showCandidate(profile: Profile)
    }

    interface Presenter: IPresenter<View> {

    }
}