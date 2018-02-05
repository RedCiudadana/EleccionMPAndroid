package eleccionmp.redciudadana.org.eleccionmp.views.candidateDetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import eleccionmp.redciudadana.org.eleccionmp.R
import eleccionmp.redciudadana.org.eleccionmp.http.Models
import kotlinx.android.synthetic.main.candidate_biography.*
import kotlinx.android.synthetic.main.candidate_contact.*
import kotlinx.android.synthetic.main.candidate_evaluation.*
import kotlinx.android.synthetic.main.candidate_evaluation_graph.*

/**
 * Created by javier on 1/30/18.
 */

const val profileArgument = "profile"

object CandidateDetailSections {
    class CandidateBiography : Fragment() {
        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater?.inflate(R.layout.candidate_biography, container, false)
        }

        override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            try {
                val text: Models.Profile = arguments.getParcelable(profileArgument)
                candidate_biography.text = text.biografia

            } catch (e: Exception) {
                // do nothing
            }
        }
    }

    class CandidateEvaluation : Fragment() {
        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater?.inflate(R.layout.candidate_evaluation, container, false)
        }

        override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            try {
                val profile: Models.Profile = arguments.getParcelable(profileArgument)
                note_academics.text = profile.notaAspectosAcademicos?.toString() ?: ""
                note_professional.text = profile.notaAspectosProfesionales?.toString() ?: ""
                note_projection.text = profile.notaProyeccionHumana?.toString() ?: ""
                note_ethics.text = if (profile.notaCualidadesEticas ?: 0 > 0) getString(R.string.candidate_evaluation_ethics_approved) else getString(R.string.candidate_evaluation_ethics_reproved)
            } catch (e: Exception) {
                // do nothing
            }
        }
    }

    class CandidateWorkPlan: Fragment() {
        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater?.inflate(R.layout.candidate_biography, container, false)
        }

        override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            try {
                val profile: Models.Profile = arguments.getParcelable(profileArgument)
                candidate_biography.text = profile.planTrabajo
            } catch (e: Exception) {
                // do nothing
            }
        }
    }

    class CandidateChart : Fragment() {
        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater?.inflate(R.layout.candidate_evaluation_graph, container, false)
        }

        override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            try {
                val profile: Models.Profile = arguments.getParcelable(profileArgument)
                val missing = 100 - ((profile.notaAspectosAcademicos
                        ?: 0) + (profile.notaAspectosProfesionales
                        ?: 0) + (profile.notaProyeccionHumana ?: 0))
                val entries = listOf<PieEntry>(
                        PieEntry(profile.notaAspectosAcademicos?.toFloat()
                                ?: 0f, getString(R.string.candidate_evaluation_academics)),
                        PieEntry(profile.notaAspectosProfesionales?.toFloat()
                                ?: 0f, getString(R.string.candidate_evaluation_professional)),
                        PieEntry(profile.notaProyeccionHumana?.toFloat()
                                ?: 0f, getString(R.string.candidate_evaluation_projection)),
                        PieEntry(missing.toFloat(), getString(R.string.candidate_evaluation_missing))
                )
                val dataSet = PieDataSet(entries, "")
                dataSet.setColors(intArrayOf(R.color.chart1, R.color.chart2, R.color.chart3, R.color.chart4), context)

                val data = PieData(dataSet)
                candidate_chart.setEntryLabelColor(ContextCompat.getColor(context, R.color.black))
                candidate_chart.data = data
                candidate_chart.invalidate()
            } catch (e: Exception) {
                // do nothing
            }
        }

    }



    class CandidatePath : Fragment() {
        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater?.inflate(R.layout.candidate_biography, container, false)
        }

        override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            try {
                val text: Models.Profile = arguments.getParcelable(profileArgument)
                candidate_biography.text = text.trayectoria
            } catch (e: Exception) {
                // do nothing
            }
        }
    }

    class CandidateContact : Fragment() {
        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater?.inflate(R.layout.candidate_contact, container, false)
        }

        override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            try {
                val profile: Models.Profile = arguments.getParcelable(profileArgument)
                if (profile.fb != null) {
                    candidate_fb.setOnClickListener {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(profile.fb))
                        startActivity(intent)
                    }
                } else {
                    candidate_fb.visibility = View.GONE
                }
                if (profile.tw != null) {
                    candidate_twitter.setOnClickListener {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(profile.tw))
                        startActivity(intent)
                    }
                } else {
                    candidate_twitter.visibility = View.GONE
                }
                if (profile.email != null) {
                    candidate_email.setOnClickListener {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("mailto:%s".format(profile.email)))
                        startActivity(intent)
                    }
                } else {
                    candidate_email.visibility = View.GONE
                }
            } catch (e: Exception) {
                // do nothing
            }
        }
    }
}