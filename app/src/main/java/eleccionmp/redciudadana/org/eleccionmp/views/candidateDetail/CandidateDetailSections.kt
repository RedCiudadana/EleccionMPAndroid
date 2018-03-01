package eleccionmp.redciudadana.org.eleccionmp.views.candidateDetail

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import eleccionmp.redciudadana.org.eleccionmp.MainActivity
import eleccionmp.redciudadana.org.eleccionmp.R
import eleccionmp.redciudadana.org.eleccionmp.http.Models
import eleccionmp.redciudadana.org.eleccionmp.utils.views.ViewGroupHelper
import kotlinx.android.synthetic.main.candidate_biography.view.*
import kotlinx.android.synthetic.main.candidate_contact.view.*
import kotlinx.android.synthetic.main.candidate_evaluation_graph.view.*

/**
 * Created by javier on 1/30/18.
 */

const val profileArgument = "profile"

object CandidateDetailSections {
    class CandidateBiography : ViewGroupHelper {
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


    class CandidateAcademics : ViewGroupHelper {
        override fun getLayout(): Int {
            return R.layout.candidate_biography
        }

        override fun populateView(context: Context, view: View, arguments: Bundle) {
            try {
                val text: Models.Profile = arguments.getParcelable(profileArgument)
                view.candidate_biography.text = text.educacion

            } catch (e: Exception) {
                // do nothing
            }
        }
    }

    class CandidateProfessional : ViewGroupHelper {
        override fun getLayout(): Int {
            return R.layout.candidate_biography
        }

        override fun populateView(context: Context, view: View, arguments: Bundle) {
            try {
                val text: Models.Profile = arguments.getParcelable(profileArgument)
                view.candidate_biography.text = text.experienciaProfesional

            } catch (e: Exception) {
                // do nothing
            }
        }

    }

    class CandidateChart : ViewGroupHelper {
        override fun getLayout(): Int {
            return R.layout.candidate_evaluation_graph
        }

        override fun populateView(context: Context, view: View, arguments: Bundle) {
            try {
                val profile: Models.Profile = arguments.getParcelable(profileArgument)
                val missing = 100 - ((profile.notaAspectosAcademicos
                        ?: 0) + (profile.notaAspectosProfesionales
                        ?: 0) + (profile.notaProyeccionHumana ?: 0))
                val entries = listOf<PieEntry>(
                        PieEntry(profile.notaAspectosAcademicos?.toFloat()
                                ?: 0f, context.getString(R.string.candidate_evaluation_academics)),
                        PieEntry(profile.notaAspectosProfesionales?.toFloat()
                                ?: 0f, context.getString(R.string.candidate_evaluation_professional)),
                        PieEntry(profile.notaProyeccionHumana?.toFloat()
                                ?: 0f, context.getString(R.string.candidate_evaluation_projection)),
                        PieEntry(missing.toFloat(), context.getString(R.string.candidate_evaluation_missing))
                )
                val dataSet = PieDataSet(entries, "")
                dataSet.setColors(intArrayOf(R.color.chart1, R.color.chart2, R.color.chart3, R.color.chart4), context)

                val data = PieData(dataSet)
                view.candidate_chart.setEntryLabelColor(ContextCompat.getColor(context, R.color.black))
                view.candidate_chart.data = data
                view.candidate_chart.invalidate()
            } catch (e: Exception) {
                // do nothing
            }
        }
    }


    class CandidateContact : ViewGroupHelper {
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