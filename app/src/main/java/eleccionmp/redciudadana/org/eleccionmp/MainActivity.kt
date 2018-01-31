package eleccionmp.redciudadana.org.eleccionmp

import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import eleccionmp.redciudadana.org.eleccionmp.http.Profile
import eleccionmp.redciudadana.org.eleccionmp.utils.views.ActivityView
import eleccionmp.redciudadana.org.eleccionmp.views.candidateDetail.CandidateDetailFragment
import eleccionmp.redciudadana.org.eleccionmp.views.candidates.CandidatesFragment
import eleccionmp.redciudadana.org.eleccionmp.views.mainmenu.MainMenuFragment
import kotlinx.android.synthetic.main.activity_main.*

interface MainView: ActivityView {
    fun showMainMenu()
    fun showCandidates()
    fun showCandidate(profile: Profile)
    fun showCommission()
    fun showElectionProcess()
    fun showNews()
    fun showContact()
}

private const val TAG: String = "MainActivity"

class MainActivity : AppCompatActivity(), MainView {
    private var mDrawerToggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeDrawer()
        if (savedInstanceState == null) {
            showMainMenu()
        }
    }

    private fun initializeDrawer() {
        setSupportActionBar(toolbar)
        mDrawerToggle = object: ActionBarDrawerToggle(
                this,
                drawer_layout,
                R.string.drawer_open,
                R.string.drawer_close
        ) {}

        drawer_layout.addDrawerListener(mDrawerToggle as ActionBarDrawerToggle)

        mDrawerToggle?.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        setDrawerNavigationListener()
    }

    private fun setDrawerNavigationListener() {
        drawer_navigation.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.option_candidates -> {
                    showCandidates()
                }
                R.id.option_commission -> {
                    showCommission()
                }
                R.id.option_news -> {
                    showNews()
                }
                R.id.option_election_process -> {
                    showElectionProcess()
                }
                R.id.option_contact -> {
                    showContact()
                }
                else -> {
                    return@setNavigationItemSelectedListener false
                }
            }
            return@setNavigationItemSelectedListener true
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

    private fun changeFragment(fragment: Fragment, addToBackStack: Boolean) {
        val transaction = supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
        drawer_layout.closeDrawer(Gravity.START)

    }

    override fun setTitle(@StringRes title: Int) {
        toolbar.setTitle(title)
    }

    override fun setTitle(title: String) {
        toolbar.title = title
    }

    override fun showMainMenu() {
        val fragment = MainMenuFragment()
        changeFragment(fragment, false);
    }



    override fun showLoading() {
        progress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress.visibility = View.GONE
    }

    override fun showCandidates() : Unit{
        val fragment = CandidatesFragment()
        changeFragment(fragment, true)
    }

    override fun showCandidate(profile: Profile) {
        val fragment = CandidateDetailFragment()
        val args = Bundle()
        args.putParcelable("profile", profile)
        fragment.arguments = args
        changeFragment(fragment, true)
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

    override fun showContact() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
