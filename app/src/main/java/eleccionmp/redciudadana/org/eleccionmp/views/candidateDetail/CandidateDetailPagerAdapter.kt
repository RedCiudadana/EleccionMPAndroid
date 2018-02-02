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
        val result: Fragment
        result = when (position) {
            0 -> CandidateDetailSections.CandidateBiography()
            1 -> CandidateDetailSections.CandidateEvaluation()
            2 -> CandidateDetailSections.CandidateChart()
            3 -> CandidateDetailSections.CandidatePath()
            4 -> CandidateDetailSections.CandidateContact()
            else -> CandidateDetailSections.CandidateBiography()
        }
        result.arguments = args
        return result
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