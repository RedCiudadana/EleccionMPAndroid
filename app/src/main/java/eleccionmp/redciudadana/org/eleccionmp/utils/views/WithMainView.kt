package eleccionmp.redciudadana.org.eleccionmp.utils.views

import android.app.Activity
import android.support.annotation.StringRes
import eleccionmp.redciudadana.org.eleccionmp.MainView

/**
 * Created by javier on 1/24/18.
 */

interface ActivityView {
    fun showLoading()
    fun hideLoading()
    fun setTitle(@StringRes title: Int)
    fun setTitle(title: String)
}