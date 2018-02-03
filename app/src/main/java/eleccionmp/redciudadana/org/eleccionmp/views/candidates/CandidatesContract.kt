package eleccionmp.redciudadana.org.eleccionmp.views.candidates

import eleccionmp.redciudadana.org.eleccionmp.http.Models
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.IPresenter
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.IView

/**
 * Created by javier on 1/24/18.
 */

object CandidatesContract {
    interface View: IView {
        fun showCandidatesList(list: List<Models.Profile>)
        fun showCandidate(profile: Models.Profile)
        fun onCandidateSelected(profile: Models.Profile)
    }

    interface Presenter: IPresenter<View> {
        fun onCandidateSelected(profile: Models.Profile)
    }
}