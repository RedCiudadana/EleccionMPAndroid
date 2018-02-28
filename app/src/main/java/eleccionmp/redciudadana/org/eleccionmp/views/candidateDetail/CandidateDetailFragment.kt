package eleccionmp.redciudadana.org.eleccionmp.views.candidateDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import eleccionmp.redciudadana.org.eleccionmp.MainView
import eleccionmp.redciudadana.org.eleccionmp.R
import eleccionmp.redciudadana.org.eleccionmp.http.Models
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.BaseFragment
import kotlinx.android.synthetic.main.fragment_candidate_detail.*

/**
 * Created by javier on 1/28/18.
 */

class CandidateDetailFragment : BaseFragment<CandidateDetailContract.View, CandidateDetailContract.Presenter, MainView>(), CandidateDetailContract.View {
    override var mPresenter: CandidateDetailContract.Presenter = CandidateDetailPresenter()

    var mCandidate: Models.Profile? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_candidate_detail, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detail_list.setAdapter(CandidateDetailListAdapter(activity, mCandidate!!))
    }

    override fun showCandidate(profile: Models.Profile) {
        mCandidate = profile
        Picasso.with(context).load(profile.fotoUrl).into(candidate_photo)
        if (profile.nombre != null) {
            candidate_name.text = profile.nombre
        }
    }

    override fun setTitle(title: String) {
        mActivityView?.setTitle(title)
    }

    override fun setTitle() {
        val nombre = mCandidate?.nombre
        if (nombre != null) {
            mActivityView?.setTitle(nombre)
        }
    }
}