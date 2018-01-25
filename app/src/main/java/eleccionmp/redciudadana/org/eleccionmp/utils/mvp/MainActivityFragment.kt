package eleccionmp.redciudadana.org.eleccionmp.utils.mvp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import eleccionmp.redciudadana.org.eleccionmp.MainView

/**
 * Created by javier on 1/24/18.
 */

abstract class MainActivityFragmentWithPresenter<in V: IView, T: IPresenter<V>>: BaseFragment<V, T>() {
    protected var mainView: MainView? = null
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        mainView = activity as MainView
        return super.onViewCreated(view, savedInstanceState)
    }
}

open class MainActivityFragment: Fragment() {
    protected var mainView: MainView? = null
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        mainView = activity as MainView
        super.onViewCreated(view, savedInstanceState)
    }
}