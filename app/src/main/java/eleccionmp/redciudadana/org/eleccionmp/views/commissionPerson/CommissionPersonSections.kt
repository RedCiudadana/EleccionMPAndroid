package eleccionmp.redciudadana.org.eleccionmp.views.commissionPerson

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eleccionmp.redciudadana.org.eleccionmp.R
import eleccionmp.redciudadana.org.eleccionmp.http.Models
import eleccionmp.redciudadana.org.eleccionmp.views.candidateDetail.profileArgument
import kotlinx.android.synthetic.main.candidate_biography.*

/**
 * Created by javier on 2/2/18.
 */
object CommissionPersonSections {

    class PersonBiography : Fragment() {
        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater?.inflate(R.layout.candidate_biography, container, false)
        }

        override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            try {
                val text: Models.Profile = arguments.getParcelable(profileArgument)
                candidate_biography.text = text.biografia

            } catch (e: Exception) {
                // do nothing
            }
        }
    }
}