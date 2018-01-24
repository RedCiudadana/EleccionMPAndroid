package eleccionmp.redciudadana.org.eleccionmp.views.candidates

import android.util.Log
import eleccionmp.redciudadana.org.eleccionmp.http.Profile
import eleccionmp.redciudadana.org.eleccionmp.http.api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by javier on 1/23/18.
 */

private const val TAG = "Candidates Presenter"

class CandidatesPresenter {
    lateinit var view: CandidatesFragment


    fun init(view: CandidatesFragment) {
        this.view = view
        view.showLoading()
        // API call test
        val callResponse = api.getProfiles()
        callResponse.enqueue(object: Callback<List<Profile>> {
            override fun onFailure(call: Call<List<Profile>>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<List<Profile>>?, response: Response<List<Profile>>?) {
                Log.d(TAG, response?.body().toString())
                view.hideLoading()
                response?.body()?.map {
                    Log.d(TAG, it.email)
                }
            }

        })
    }

}