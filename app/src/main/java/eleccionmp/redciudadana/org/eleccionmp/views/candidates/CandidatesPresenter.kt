package eleccionmp.redciudadana.org.eleccionmp.views.candidates

import eleccionmp.redciudadana.org.eleccionmp.R
import eleccionmp.redciudadana.org.eleccionmp.http.Models
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.BasePresenter

/**
 * Created by javier on 1/23/18.
 */

class CandidatesPresenter : BasePresenter<CandidatesContract.View>(), CandidatesContract.Presenter {

    override fun onViewCreated() {
        mView?.setTitle()
        mView?.showLoading()
        Models.getCandidates { list: List<Models.Profile>?, throwable: Throwable? ->
            if (throwable != null) {
                mView?.showError(R.string.errors_could_not_load)
            } else {
                mView?.hideLoading()
                mView?.showCandidatesList(list!!)
            }
        }
    }

    override fun onCandidateSelected(profile: Models.Profile) {
        mView?.showCandidate(profile)
    }
}