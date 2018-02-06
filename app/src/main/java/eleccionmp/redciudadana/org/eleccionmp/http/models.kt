package eleccionmp.redciudadana.org.eleccionmp.http

import android.os.Parcelable
import android.util.Log
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by javier on 1/15/18.
 */

const val TAG = "Models"

object Models {

    var candidates: List<Profile>? = null
    var commission: List<Profile>? = null
    var evaluations: List<Evaluations>? = null

    @Parcelize
    data class Profile(
            val id: String?,
            val nombre: String?,
            val cargo: String?,
            val institucion: String?,
            val profesion: String?,
            val educacion: String?,
            val fechaNacimiento: String?,
            val lugarNacimiento: String?,
            val biografia: String?,
            val trayectoria: String?,
            val planTrabajo: String?,
            val experienciaProfesional: String?,
            val experienciaEnDH: String?,
            val resultadosEvaluacion: Int?,
            @Json(name = "notaAreaEvaluada1")
            val notaAspectosAcademicos: Int?,
            @Json(name = "notaAreaEvaluada2")
            val notaAspectosProfesionales: Int?,
            @Json(name = "notaAreaEvaluada3")
            val notaProyeccionHumana: Int?,
            @Json(name = "notaAreaEvaluada4")
            val notaCualidadesEticas: Int?,
            val sexo: String?,
            val estado: String?,
            val fb: String?,
            val tw: String?,
            val email: String?,
            @Json(name = "fb-institucion")
            val fbInstitucion: String?,
            @Json(name = "tw-institucion")
            val twInstitucion: String?,
            @Json(name = "email-institucion")
            val emailInstitucion: String?,
            val fotoUrl: String?,
            val telefono: String?,
            val direccion: String?,
            val web: String
    ) : Parcelable

    @Parcelize
    data class Evaluations(
            val postuladorId: String?,
            val perfilId: String?,
            val resultado: String?
    ) : Parcelable

    data class EvaluationResult(
            val perfil: Profile,
            val resultado: String
    )

    fun getCandidates(callback: ((List<Profile>?, Throwable?) -> Unit)?) {
        if (candidates != null) {
            if (callback != null) callback(candidates, null)
        } else {
            val callResponse = api.getProfiles()
            callResponse.enqueue(object : Callback<List<Profile>> {
                override fun onFailure(call: Call<List<Profile>>?, t: Throwable?) {
                    if (callback != null) callback(null, t)
                }

                override fun onResponse(call: Call<List<Profile>>?, response: Response<List<Profile>>?) {
                    Log.d(TAG, response?.body().toString())
                    candidates = response?.body()
                    if (callback != null) callback(response?.body(), null)
                }

            })
        }
    }

    fun getCommission(callback: ((List<Profile>?, Throwable?) -> Unit)?) {
        if (commission != null) {
            if (callback != null) callback(commission, null)
        } else {
            val callResponse = api.getCommission()
            callResponse.enqueue(object : Callback<List<Profile>> {
                override fun onFailure(call: Call<List<Profile>>?, t: Throwable?) {
                    if (callback != null) callback(null, t)
                }

                override fun onResponse(call: Call<List<Profile>>?, response: Response<List<Profile>>?) {
                    commission = response?.body()
                    if (callback != null) callback(response?.body(), null)
                }
            })
        }
    }

    fun getEvaluations(callback: ((List<Evaluations>?, Throwable?) -> Unit)?) {
        if (evaluations != null) {
            if (callback != null) {
                callback(evaluations, null)
            }
        } else {
            val callResponse = api.getEvaluations()
            callResponse.enqueue(object : Callback<List<Evaluations>> {
                override fun onFailure(call: Call<List<Evaluations>>?, t: Throwable?) {
                    if (callback != null) callback(null, t)
                }

                override fun onResponse(call: Call<List<Evaluations>>?, response: Response<List<Evaluations>>?) {
                    evaluations = response?.body()
                    if (callback != null) callback(evaluations, null)
                }
            })
        }
    }


    fun getEvaluationFor(commissionPerson: Profile, callback: (List<EvaluationResult>?) -> Unit) {
        getCandidates { _, _ ->
            getCommission { _, _ ->
                getEvaluations { _, _ ->
                    callback(findEvaluation(commissionPerson))
                }
            }
        }
    }

    private fun findEvaluation(commissionPerson: Profile): List<EvaluationResult>? {
        val evaluations = evaluations!!
        var profileIdList = HashMap<String, String>()
        for (evaluation in evaluations) {
            if (evaluation.postuladorId == commissionPerson.id) {
                profileIdList.put(evaluation.perfilId!!, evaluation.resultado!!)
            }
        }
        val resultList = ArrayList<EvaluationResult>()
        for (profile in candidates!!) {
            val score = profileIdList[profile.id]
            if (score != null) {
                resultList.add(EvaluationResult(profile, score))
            }
        }
        return resultList
    }


}

