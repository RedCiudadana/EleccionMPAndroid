package eleccionmp.redciudadana.org.eleccionmp.views.candidates

import android.util.Log
import eleccionmp.redciudadana.org.eleccionmp.R
import eleccionmp.redciudadana.org.eleccionmp.http.Profile
import eleccionmp.redciudadana.org.eleccionmp.http.api
import eleccionmp.redciudadana.org.eleccionmp.utils.mvp.BasePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by javier on 1/23/18.
 */

private const val TAG = "Candidates Presenter"

class CandidatesPresenter : BasePresenter<CandidatesContract.View>(), CandidatesContract.Presenter {

    override fun onViewCreated() {
        mView?.setTitle()
        mView?.showLoading()
        val callResponse = api.getProfiles()
        callResponse.enqueue(object : Callback<List<Profile>> {
            override fun onFailure(call: Call<List<Profile>>?, t: Throwable?) {
                mView!!.showError(R.string.errors_could_not_load)
            }

            override fun onResponse(call: Call<List<Profile>>?, response: Response<List<Profile>>?) {
                Log.d(TAG, response?.body().toString())
                Log.d(TAG, "View is " + mView.toString())
                mView?.hideLoading()
                mView!!.showCandidatesList(response!!.body())
            }

        })
    }

    override fun onCandidateSelected(profile: Profile) {
        mView?.showCandidate(profile)
    }
}