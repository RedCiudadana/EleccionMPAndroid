package eleccionmp.redciudadana.org.eleccionmp.views.election

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.davemorrissey.labs.subscaleview.ImageSource
import eleccionmp.redciudadana.org.eleccionmp.MainActivity
import eleccionmp.redciudadana.org.eleccionmp.R
import kotlinx.android.synthetic.main.fragment_election.*

/**
 * Created by javier on 2/3/18.
 */

class ElectionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_election, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        election_image.setImage(
                ImageSource.resource(R.drawable.election_process).dimensions(2229, 2652),
                ImageSource.resource(R.drawable.election_process_preview)
        )
    }

    override fun onResume() {
        super.onResume()
        val activity = activity as MainActivity
        activity.setTitle(R.string.election_title)
    }
}