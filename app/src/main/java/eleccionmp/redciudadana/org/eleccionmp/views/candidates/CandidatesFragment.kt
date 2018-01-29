package eleccionmp.redciudadana.org.eleccionmp.views.candidates

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eleccionmp.redciudadana.org.eleccionmp.MainView
import eleccionmp.redciudadana.org.eleccionmp.R
import eleccionmp.redciudadana.org.eleccionmp.http.Profile
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.BaseFragment
import kotlinx.android.synthetic.main.fragment_candidates.*

/**
 * Created by javier on 1/23/18.
 * Candidates fragment
 */

class CandidatesFragment : BaseFragment<CandidatesContract.View, CandidatesContract.Presenter, MainView>(), CandidatesContract.View {

    override var mPresenter: CandidatesContract.Presenter = CandidatesPresenter()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_candidates, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mLayoutManager = LinearLayoutManager(context)
        candidates_list.setHasFixedSize(true)
        candidates_list.layoutManager = mLayoutManager
        candidates_list.adapter = CandidateListAdapter(context, this, null)
    }

    override fun setTitle() {
        mActivityView?.setTitle(R.string.candidates_title)
    }

    override fun showCandidatesList(list: List<Profile>) {
        val adapter = candidates_list.adapter as CandidateListAdapter
        adapter.candidateList = list
    }

    override fun onCandidateSelected(profile: Profile) {
        mPresenter.onCandidateSelected(profile)
    }

    override fun showCandidate(profile: Profile) {
        mActivityView?.showCandidate(profile)
    }
}