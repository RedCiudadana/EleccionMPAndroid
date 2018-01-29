package eleccionmp.redciudadana.org.eleccionmp.views.candidateDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eleccionmp.redciudadana.org.eleccionmp.MainView
import eleccionmp.redciudadana.org.eleccionmp.R
import eleccionmp.redciudadana.org.eleccionmp.http.Profile
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.BaseFragment

/**
 * Created by javier on 1/28/18.
 */

class CandidateDetailFragment: BaseFragment<CandidateDetailContract.View, CandidateDetailContract.Presenter, MainView>(), CandidateDetailContract.View {
    override var mPresenter: CandidateDetailContract.Presenter = CandidateDetailPresenter()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_candidate_detail, container, false)
    }

    override fun showCandidate(profile: Profile) {

    }
}