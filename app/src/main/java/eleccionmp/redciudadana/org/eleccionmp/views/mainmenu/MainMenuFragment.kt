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

class MainMenuFragment: Fragment() {
    private var mainView: MainView? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mainView = activity as MainView
        val view = inflater?.inflate(R.layout.fragment_main_menu, container, false)
        option_candidates.setOnClickListener {
            mainView?.showCandidates()
        }
        option_commission.setOnClickListener {
            mainView?.showCommission()
        }
        option_election_process.setOnClickListener {
            mainView?.showElectionProcess()
        }
        option_news.setOnClickListener {
            mainView?.showNews()
        }
        return view
    }
}