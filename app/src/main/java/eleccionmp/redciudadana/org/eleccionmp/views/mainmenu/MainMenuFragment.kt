package eleccionmp.redciudadana.org.eleccionmp.views.mainmenu

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eleccionmp.redciudadana.org.eleccionmp.MainView
import eleccionmp.redciudadana.org.eleccionmp.R
import kotlinx.android.synthetic.main.fragment_main_menu.*

/**
 * Created by javier on 1/17/18.
 * Main menu fragment to show main features of this app
 */

class MainMenuFragment : Fragment() {

    fun getMainView(): MainView {
        return activity as MainView
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_main_menu, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        option_candidates.setOnClickListener {
            getMainView().showCandidates()
        }
        option_commission.setOnClickListener {
            getMainView().showCommission()
        }
        option_election_process.setOnClickListener {
            getMainView().showElectionProcess()
        }
        option_news.setOnClickListener {
            getMainView().showNews()
        }
    }
}