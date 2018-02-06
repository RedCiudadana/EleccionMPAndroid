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
        val result: Fragment = when (position) {
            0 -> CandidateDetailSections.CandidateBiography()
            1 -> CandidateDetailSections.CandidateAcademics()
            2 -> CandidateDetailSections.CandidateProfessional()
            3 -> CandidateDetailSections.CandidateChart()
            else -> CandidateDetailSections.CandidateContact()
        }
        result.arguments = args
        return result
    }

    override fun getCount(): Int {
        return 5
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> context.getString(R.string.candidate_biography)
            1 -> context.getString(R.string.candidate_academics)
            2 -> context.getString(R.string.candidate_professional)
            3 -> context.getString(R.string.candidate_evaluation)
            else -> context.getString(R.string.candidate_ask)
        }

    }
}