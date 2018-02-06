package eleccionmp.redciudadana.org.eleccionmp.views.candidateDetail

import eleccionmp.redciudadana.org.eleccionmp.http.Models
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.BasePresenter

/**
 * Created by javier on 1/28/18.
 */

class CandidateDetailPresenter: BasePresenter<CandidateDetailContract.View>(), CandidateDetailContract.Presenter {

    override fun onViewCreated() {
        val args = mView?.getArguments()
        val profile: Models.Profile? = args?.getParcelable("profile")
        if (profile != null) {
            mView?.showCandidate(profile)
            if (profile.nombre != null){
                mView?.setTitle(profile.nombre)
            }
        }
    }
}