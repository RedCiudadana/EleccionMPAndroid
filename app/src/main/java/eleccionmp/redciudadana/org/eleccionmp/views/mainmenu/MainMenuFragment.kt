package eleccionmp.redciudadana.org.eleccionmp.views.mainmenu

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import eleccionmp.redciudadana.org.eleccionmp.MainView
import eleccionmp.redciudadana.org.eleccionmp.R

/**
 * Created by javier on 1/17/18.
 * Main menu fragment to show main features of this app
 */

class MainMenuFragment: Fragment() {
    private var mainView: MainView? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mainView = activity as MainView
        val view: View? = inflater?.inflate(R.layout.fragment_main_menu, container, false)
        val option1 = view?.findViewById<View>(R.id.option_candidates)
        option1?.setOnClickListener {
            Toast.makeText(context, "Me hizo click", Toast.LENGTH_SHORT).show()
        }
        return view
    }
}