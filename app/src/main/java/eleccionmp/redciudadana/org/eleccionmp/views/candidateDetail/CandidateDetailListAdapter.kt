package eleccionmp.redciudadana.org.eleccionmp.views.candidateDetail

import android.content.Context
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import eleccionmp.redciudadana.org.eleccionmp.R
import eleccionmp.redciudadana.org.eleccionmp.http.Models
import org.w3c.dom.Text

/**
 * Created by javier on 2/27/18.
 */

class CandidateDetailListAdapter(val context: Context, val profile: Models.Profile) : BaseExpandableListAdapter() {

    val groupTitles = arrayListOf<String>(
            context.getString(R.string.candidate_biography),
            context.getString(R.string.candidate_academics),
            context.getString(R.string.candidate_professional),
            context.getString(R.string.candidate_evaluation),
            context.getString(R.string.candidate_ask)
    )

    override fun getGroup(groupPosition: Int): Any {
        return groupTitles[groupPosition]
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView: TextView? = convertView as TextView?
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.candidate_detail_header, parent, false) as TextView
        }
        convertView.text = getGroup(groupPosition) as String
        return convertView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return 1
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return when (groupPosition) {
            0 -> CandidateDetailSections.CandidateBiography()
            1 -> CandidateDetailSections.CandidateAcademics()
            2 -> CandidateDetailSections.CandidateProfessional()
            3 -> CandidateDetailSections.CandidateChart()
            else -> CandidateDetailSections.CandidateContact()
        }
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        val helper = getChild(groupPosition, childPosition) as ViewGroupHelper
        val args = Bundle()
        args.putParcelable(profileArgument, profile)
        if (view == null) {
            view = LayoutInflater.from(context).inflate(helper.getLayout(), parent, false)
        }
        helper.populateView(context, view!!, args)
        return view
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return groupTitles.size
    }

    override fun getChildTypeCount(): Int {
        return groupTitles.size
    }

    override fun getChildType(groupPosition: Int, childPosition: Int): Int {
        return groupPosition
    }
}