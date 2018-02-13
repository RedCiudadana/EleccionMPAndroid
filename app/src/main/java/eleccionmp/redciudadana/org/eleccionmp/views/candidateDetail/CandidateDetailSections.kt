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
import eleccionmp.redciudadana.org.eleccionmp.MainActivity
import eleccionmp.redciudadana.org.eleccionmp.R
import eleccionmp.redciudadana.org.eleccionmp.http.Models
import kotlinx.android.synthetic.main.candidate_biography.*
import kotlinx.android.synthetic.main.candidate_contact.*
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

    class CandidateAcademics : Fragment() {
        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater?.inflate(R.layout.candidate_biography, container, false)
        }

        override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            try {
                val text: Models.Profile = arguments.getParcelable(profileArgument)
                candidate_biography.text = text.educacion

            } catch (e: Exception) {
                // do nothing
            }
        }
    }

    class CandidateProfessional : Fragment() {
        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater?.inflate(R.layout.candidate_biography, container, false)
        }

        override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            try {
                val text: Models.Profile = arguments.getParcelable(profileArgument)
                candidate_biography.text = text.experienciaProfesional

            } catch (e: Exception) {
                // do nothing
            }
        }
    }


    class CandidateWorkPlan : Fragment() {
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
                        startIntent(intent)
                    }
                } else {
                    candidate_fb.visibility = View.GONE
                }
                if (profile.tw != null) {
                    candidate_twitter.setOnClickListener {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(profile.tw))
                        startIntent(intent)
                    }
                } else {
                    candidate_twitter.visibility = View.GONE
                }
                if (profile.email != null) {
                    candidate_email.setOnClickListener {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("mailto:%s".format(profile.email)))
                        startIntent(intent)
                    }
                } else {
                    candidate_email.visibility = View.GONE
                }
            } catch (e: Exception) {
                val activity = getActivity() as MainActivity
                activity.showError("Error", getString(R.string.errors_could_not_load))
            }
        }

        private fun startIntent(intent: Intent) {
            try {
                startActivity(intent)
            } catch (e: Exception) {
                val activity = activity as MainActivity
                activity.showError("Error", getString(R.string.errors_could_not_open_link))
            }
        }
    }
}