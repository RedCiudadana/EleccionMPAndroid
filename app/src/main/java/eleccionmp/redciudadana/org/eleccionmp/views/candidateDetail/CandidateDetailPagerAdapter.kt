package eleccionmp.redciudadana.org.eleccionmp.views.candidateDetail

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by javier on 1/30/18.
 */

class CandidateDetailPagerAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return CandidateDetailSections.CandidateBiography()
            else -> return CandidateDetailSections.CandidateBiography()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "Test"
    }
}