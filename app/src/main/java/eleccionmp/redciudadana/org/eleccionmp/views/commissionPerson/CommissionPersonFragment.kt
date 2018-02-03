package eleccionmp.redciudadana.org.eleccionmp.views.commissionPerson

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
 * Created by javier on 2/2/18.
 */

class CommissionPersonFragment : BaseFragment<CommissionPersonContract.View, CommissionPersonContract.Presenter, MainView>(), CommissionPersonContract.View {

    override var mPresenter: CommissionPersonContract.Presenter = CommissionPersonPresenter()

    var mPerson: Models.Profile? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_candidate_detail, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        candidate_detail_pager.adapter = CommissionPersonPagerAdapter(activity.supportFragmentManager, context, mPerson!!)
    }

    override fun showPerson(profile: Models.Profile) {
        mPerson = profile
        Picasso.with(context).load(profile.fotoUrl).into(candidate_photo)
        if (profile.nombre != null) {
            candidate_name.text = profile.nombre
        }
    }

    override fun setTitle(title: String) {
        mActivityView?.setTitle(title)
    }

}