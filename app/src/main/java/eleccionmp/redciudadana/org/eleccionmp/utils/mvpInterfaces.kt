package eleccionmp.redciudadana.org.eleccionmp.utils

/**
 * Created by javier on 1/23/18.
 */

interface IPresenter {
    fun <T: IView> init(view: T)
}

interface IView {
    fun showLoading()
    fun hideLoading()
}