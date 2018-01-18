package eleccionmp.redciudadana.org.eleccionmp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import eleccionmp.redciudadana.org.eleccionmp.http.Api
import eleccionmp.redciudadana.org.eleccionmp.http.Profile
import eleccionmp.redciudadana.org.eleccionmp.views.mainmenu.MainMenuFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG: String = "MainActivity"
    private val api: Api = Api();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val callResponse = api.api.getProfiles()
        callResponse.enqueue(object: Callback<List<Profile>> {
            override fun onFailure(call: Call<List<Profile>>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<List<Profile>>?, response: Response<List<Profile>>?) {
                Log.d(TAG, response?.body().toString())
                response?.body()?.map {
                    Log.d(TAG, it.email)
                }
            }

        })
    }

    override fun onResume() {
        super.onResume()
        showMainMenu();
    }

    fun showMainMenu() {
        val fragment = MainMenuFragment()
        changeFragment(fragment, true);
    }

    private fun changeFragment(fragment: Fragment, addToBackStack: Boolean) {
        val transaction = supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()

    }
}
