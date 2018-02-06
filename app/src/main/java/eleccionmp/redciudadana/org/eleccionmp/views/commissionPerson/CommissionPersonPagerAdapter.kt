package eleccionmp.redciudadana.org.eleccionmp.views.commissionPerson

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import eleccionmp.redciudadana.org.eleccionmp.R
import eleccionmp.redciudadana.org.eleccionmp.http.Models
import eleccionmp.redciudadana.org.eleccionmp.views.candidateDetail.profileArgument

/**
 * Created by javier on 2/2/18.
 */
class CommissionPersonPagerAdapter(
        fragmentManager: FragmentManager,
        val context: Context,
        val profile: Models.Profile) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        val args = Bundle()
        args.putParcelable(profileArgument, profile)
        val result: Fragment = when (position) {
            0 -> CommissionPersonSections.PersonBiography()
            1 -> CommissionPersonSections.PersonPath()
            2 -> CommissionPersonSections.PersonEvaluation()
            else -> CommissionPersonSections.PersonContact()
        }
        result.arguments = args
        return result
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> context.getString(R.string.candidate_biography)
            1 -> context.getString(R.string.candidate_path)
            2 -> context.getString(R.string.candidate_evaluation)
            else -> context.getString(R.string.candidate_ask)
        }
    }
}