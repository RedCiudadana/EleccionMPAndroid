package eleccionmp.redciudadana.org.eleccionmp

import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.view.View
import eleccionmp.redciudadana.org.eleccionmp.http.Api
import eleccionmp.redciudadana.org.eleccionmp.http.Profile
import eleccionmp.redciudadana.org.eleccionmp.views.mainmenu.MainMenuFragment
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface MainView {
    fun showMainMenu()
    fun showCandidates()
    fun showCommission()
    fun showElectionProcess()
    fun showNews()
}

private const val TAG: String = "MainActivity"

class MainActivity : AppCompatActivity(), MainView {
    private val api: Api = Api()
    private var mDrawerToggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mDrawerToggle = object: ActionBarDrawerToggle(
                this,
                drawer_layout,
                R.string.drawer_open,
                R.string.drawer_close
        ) {
            override fun onDrawerClosed(drawerView: View?) {
                super.onDrawerClosed(drawerView)
            }

            override fun onDrawerOpened(drawerView: View?) {
                super.onDrawerOpened(drawerView)

            }
        }
        drawer_layout.addDrawerListener(mDrawerToggle as ActionBarDrawerToggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        // API call test
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
        if (savedInstanceState == null) {
            showMainMenu()
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        mDrawerToggle?.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        mDrawerToggle?.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (mDrawerToggle?.onOptionsItemSelected(item)!!) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showMainMenu() {
        val fragment = MainMenuFragment()
        changeFragment(fragment, false);
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

    override fun showCandidates() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showCommission() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showElectionProcess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNews() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
