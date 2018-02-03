package eleccionmp.redciudadana.org.eleccionmp.views.contactUs

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eleccionmp.redciudadana.org.eleccionmp.MainActivity
import eleccionmp.redciudadana.org.eleccionmp.R
import kotlinx.android.synthetic.main.fragment_contact_us.*

/**
 * Created by javier on 2/2/18.
 */

class ContactsUsFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_contact_us, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        send_button.setOnClickListener {
            val from = input_from.text.toString()
            val message = input_message.text.toString()
            val to = getString(R.string.contact_us_email)
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", to, null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contacto de " + from)
            emailIntent.putExtra(Intent.EXTRA_TEXT, message)
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
            startActivity(Intent.createChooser(emailIntent, "Enviar correo..."))
        }
    }

    override fun onResume() {
        super.onResume()
        val activity = activity as MainActivity
        activity.setTitle(R.string.contact_us_title)
    }
}