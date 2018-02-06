package eleccionmp.redciudadana.org.eleccionmp.views.splash

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.text.Html
import eleccionmp.redciudadana.org.eleccionmp.MainActivity
import eleccionmp.redciudadana.org.eleccionmp.R
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * Created by javier on 2/3/18.
 */

class SplashActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            splash_text.text = Html.fromHtml(getString(R.string.splash_text), Html.FROM_HTML_MODE_LEGACY)
        } else {
            splash_text.text = Html.fromHtml(getString(R.string.splash_text))
        }
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}