package eleccionmp.redciudadana.org.eleccionmp.views.commission

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eleccionmp.redciudadana.org.eleccionmp.MainView
import eleccionmp.redciudadana.org.eleccionmp.R
import eleccionmp.redciudadana.org.eleccionmp.http.Models
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.BaseFragment
import kotlinx.android.synthetic.main.fragment_candidates.*

/**
 * Created by javier on 2/1/18.
 */

class CommissionFragment : BaseFragment<CommissionContract.View, CommissionContract.Presenter, MainView>(), CommissionContract.View {

    override var mPresenter: CommissionContract.Presenter = CommissionPresenter()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_candidates, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val mLayoutManager = LinearLayoutManager(context)
        candidates_list.setHasFixedSize(true)
        candidates_list.layoutManager = mLayoutManager
        candidates_list.adapter = CommissionListAdapter(context, this, null)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun showCommisionPerson(profile: Models.Profile) {
        mActivityView?.showCommissionPerson(profile)
    }

    override fun onCommissionPersonSelected(profile: Models.Profile) {
        mPresenter.onCommissionPersonSelected(profile)
    }

    override fun showCommissionList(list: List<Models.Profile>) {
        val adapter = candidates_list.adapter as CommissionListAdapter
        adapter.commissionList = list
    }

    override fun setTitle() {
        mActivityView?.setTitle(R.string.commission_title)
    }


}