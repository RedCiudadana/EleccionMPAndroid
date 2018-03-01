package eleccionmp.redciudadana.org.eleccionmp.views.commissionPerson

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import eleccionmp.redciudadana.org.eleccionmp.MainActivity
import eleccionmp.redciudadana.org.eleccionmp.R
import eleccionmp.redciudadana.org.eleccionmp.http.Models
import eleccionmp.redciudadana.org.eleccionmp.utils.views.ViewGroupHelper
import eleccionmp.redciudadana.org.eleccionmp.views.candidateDetail.profileArgument
import kotlinx.android.synthetic.main.candidate_biography.view.*
import kotlinx.android.synthetic.main.candidate_contact.view.*
import kotlinx.android.synthetic.main.fragment_candidates.view.*

/**
 * Created by javier on 2/2/18.
 */
object CommissionPersonSections {

    class PersonBiography : ViewGroupHelper {
        override fun getLayout(): Int {
            return R.layout.candidate_biography
        }

        override fun populateView(context: Context, view: View, arguments: Bundle) {
            try {
                val text: Models.Profile = arguments.getParcelable(profileArgument)
                view.candidate_biography.text = text.biografia
            } catch (e: Exception) {
                // do nothing
            }
        }
    }

    class PersonEvaluation : ViewGroupHelper {
        var mAdapter: CommissionPersonEvaluationsAdapter? = null
        override fun getLayout() = R.layout.fragment_candidates_evaluations

        override fun populateView(context: Context, view: View, arguments: Bundle) {
            view.candidates_list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            mAdapter = CommissionPersonEvaluationsAdapter(context, this, null)
            view.candidates_list.adapter = mAdapter
            view.candidates_list.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            try {
                val profile: Models.Profile = arguments.getParcelable(profileArgument)
                Models.getEvaluationFor(context, profile) {
                    mAdapter?.candidatesList = it
                }
            } catch (e: Exception) {
                // do nothing
            }
        }
    }


    class PersonPath : ViewGroupHelper {
        override fun getLayout() = R.layout.candidate_biography

        override fun populateView(context: Context, view: View, arguments: Bundle) {
            try {
                val text: Models.Profile = arguments.getParcelable(profileArgument)
                view.candidate_biography.text = text.trayectoria
            } catch (e: Exception) {
                // do nothing
            }
        }
    }

    class PersonContact : ViewGroupHelper {
        override fun getLayout(): Int {
            return R.layout.candidate_contact
        }

        override fun populateView(context: Context, view: View, arguments: Bundle) {
            try {
                val profile: Models.Profile = arguments.getParcelable(profileArgument)
                if (profile.fb != null) {
                    view.candidate_fb.setOnClickListener {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(profile.fb))
                        startIntent(context, intent)
                    }
                } else {
                    view.candidate_fb.visibility = View.GONE
                }
                if (profile.tw != null) {
                    view.candidate_twitter.setOnClickListener {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(profile.tw))
                        startIntent(context, intent)
                    }
                } else {
                    view.candidate_twitter.visibility = View.GONE
                }
                if (profile.email != null) {
                    view.candidate_email.setOnClickListener {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("mailto:%s".format(profile.email)))
                        startIntent(context, intent)
                    }
                } else {
                    view.candidate_email.visibility = View.GONE
                }
            } catch (e: Exception) {

            }
        }

        private fun startIntent(context: Context, intent: Intent) {
            try {
                context.startActivity(intent)
            } catch (e: Exception) {
                val activity = context as MainActivity
                activity.showError("Error", context.getString(R.string.errors_could_not_open_link))
            }
        }
    }

}