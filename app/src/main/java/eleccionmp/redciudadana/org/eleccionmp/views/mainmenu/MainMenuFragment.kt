package eleccionmp.redciudadana.org.eleccionmp.views.mainmenu

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eleccionmp.redciudadana.org.eleccionmp.R

/**
 * Created by javier on 1/17/18.
 */

class MainMenuFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View? = inflater?.inflate(R.layout.fragment_main_menu, container, false);

        return view;
    }
}