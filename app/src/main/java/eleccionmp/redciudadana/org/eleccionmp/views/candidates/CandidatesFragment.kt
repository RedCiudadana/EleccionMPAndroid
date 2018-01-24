package eleccionmp.redciudadana.org.eleccionmp.views.candidates

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eleccionmp.redciudadana.org.eleccionmp.utils.IView

/**
 * Created by javier on 1/23/18.
 */

class CandidatesFragment: Fragment(), IView {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val presenter = CandidatesPresenter()
        presenter.init(this)
        return null
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}