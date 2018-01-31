package eleccionmp.redciudadana.org.eleccionmp.views.candidateDetail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eleccionmp.redciudadana.org.eleccionmp.R

/**
 * Created by javier on 1/30/18.
 */

object CandidateDetailSections {
    class CandidateBiography: Fragment() {
        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater?.inflate(R.layout.candidate_biography, container, false)
        }
    }
}