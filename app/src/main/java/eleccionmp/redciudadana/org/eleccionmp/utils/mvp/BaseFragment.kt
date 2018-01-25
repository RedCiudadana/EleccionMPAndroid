package eleccionmp.redciudadana.org.eleccionmp.utils.mvp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

/**
 * Created by javier on 1/24/18.
 */

abstract class BaseFragment<in V: IView, T: IPresenter<V>>: Fragment(), IView {

    protected abstract var mPresenter: T

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.attachView(this as V)
        mPresenter.onViewCreated()
    }


    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(messageRes: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroyView() {
        mPresenter.detachView()
        super.onDestroyView()
    }
}