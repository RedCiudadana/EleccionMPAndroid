package eleccionmp.redciudadana.org.eleccionmp.views.candidateDetail

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import eleccionmp.redciudadana.org.eleccionmp.R
import eleccionmp.redciudadana.org.eleccionmp.http.Models

/**
 * Created by javier on 1/30/18.
 */

class CandidateDetailPagerAdapter(fragmentManager: FragmentManager, val context: Context, val profile: Models.Profile) : FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        val args = Bundle()
        args.putParcelable(profileArgument, profile)
        when (position) {
            0 -> {
                val result = CandidateDetailSections.CandidateBiography()
                result.arguments = args
                return result
            }
            else -> return CandidateDetailSections.CandidateBiography()
        }
    }

    override fun getCount(): Int {
        return 5
    }

    override fun getPageTitle(position: Int): CharSequence {
        when (position) {
            0 -> return context.getString(R.string.candidate_biography)
            1 -> return context.getString(R.string.candidate_evaluation)
            2 -> return context.getString(R.string.candidate_results)
            3 -> return context.getString(R.string.candidate_path)
            else -> return context.getString(R.string.candidate_ask)
        }

    }
}