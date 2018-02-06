package eleccionmp.redciudadana.org.eleccionmp.views.candidateDetail

import eleccionmp.redciudadana.org.eleccionmp.http.Models
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.IPresenter
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.IView

/**
 * Created by javier on 1/28/18.
 */

object CandidateDetailContract {
    interface View: IView {
        fun showCandidate(profile: Models.Profile)
        fun setTitle(title: String)
    }

    interface Presenter: IPresenter<View> {

    }
}