package eleccionmp.redciudadana.org.eleccionmp.utils.mvp

import android.content.Context
import android.support.annotation.StringRes

/**
 * Created by javier on 1/23/18.
 */

interface IPresenter<in V: IView> {
    fun attachView(view: V)
    fun detachView()
    fun onViewCreated()
}

interface IView {
    fun getContext(): Context
    fun showLoading()
    fun hideLoading()
    fun showError(message: String)
    fun showError(@StringRes messageRes: Int)
}