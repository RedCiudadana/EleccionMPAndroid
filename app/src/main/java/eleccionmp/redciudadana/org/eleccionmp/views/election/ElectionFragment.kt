package eleccionmp.redciudadana.org.eleccionmp.views.election

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eleccionmp.redciudadana.org.eleccionmp.MainActivity
import eleccionmp.redciudadana.org.eleccionmp.R

/**
 * Created by javier on 2/3/18.
 */

class ElectionFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_election, container, false)
    }

    override fun onResume() {
        super.onResume()
        val activity = activity as MainActivity
        activity.setTitle(R.string.contact_us_title)
    }
}