package eleccionmp.redciudadana.org.eleccionmp.http

import android.annotation.SuppressLint
import android.content.Context
import android.os.Parcelable
import android.util.Log
import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import eleccionmp.redciudadana.org.eleccionmp.utils.Storage
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

    @SuppressLint("ParcelCreator")
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
            val resultadosEvaluacionString: String?,
            @Json(name = "notaAreaEvaluada1")
            val notaAreaEvaluada1: String?,
            @Json(name = "notaAreaEvaluada2")
            val notaAreaEvaluada2: String?,
            @Json(name = "notaAreaEvaluada3")
            val notaAreaEvaluada3: String?,
            @Json(name = "notaAreaEvaluada4")
            val notaAreaEvaluada4: String?,
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
            val web: String?
    ) : Parcelable {
        val resultadosEvaluacion: Int?
        get() {
            return try {
                resultadosEvaluacionString?.toInt() ?: 0
            } catch (e: Exception) {
                null
            }
        }
        val notaAspectosAcademicos: Int?
            get() {
                return try {
                     notaAreaEvaluada1?.toInt() ?: 0
                } catch (e: Exception) {
                    null
                }
            }
        val notaAspectosProfesionales: Int?
            get() {
                return try {
                    notaAreaEvaluada2?.toInt() ?: 0
                } catch (e: Exception) {
                    null
                }
            }
        val notaProyeccionHumana: Int?
            get() {
                return try {
                    notaAreaEvaluada3?.toInt() ?: 0
                } catch (e: Exception) {
                    null
                }
            }
        val notaCualidadesEticas: Int?
            get() {
                return try {
                    notaAreaEvaluada4?.toInt() ?: 0
                } catch (e: Exception) {
                    null
                }
            }
    }

    @SuppressLint("ParcelCreator")
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

    fun getCandidates(context: Context, callback: ((List<Profile>?, Throwable?) -> Unit)?) {
        if (candidates != null) {
            if (callback != null) callback(candidates, null)
        } else {
            val callResponse = api.getProfiles()
            callResponse.enqueue(object : Callback<List<Profile>> {
                override fun onFailure(call: Call<List<Profile>>?, t: Throwable?) {
                    val stored = ModelStorage.getCandidatesFromStorage(context)
                    if (stored != null && callback != null) {
                        callback(stored, null)
                    } else if (callback != null) {
                        callback(null, t)
                    }
                }

                override fun onResponse(call: Call<List<Profile>>?, response: Response<List<Profile>>?) {
                    Log.d(TAG, response?.body().toString())
//                    val orderedResponse = response?.body()?.sortedBy { profile1 -> profile1.nombre }
                    val currentCandidates = response?.body()
                    candidates = currentCandidates
                    if (currentCandidates != null) {
                        ModelStorage.saveCandidatesToStorage(context, currentCandidates)
                    }
                    if (callback != null) callback(response?.body(), null)
                }

            })
        }
    }

    fun getCommission(context: Context, callback: ((List<Profile>?, Throwable?) -> Unit)?) {
        if (commission != null) {
            if (callback != null) callback(commission, null)
        } else {
            val callResponse = api.getCommission()
            callResponse.enqueue(object : Callback<List<Profile>> {
                override fun onFailure(call: Call<List<Profile>>?, t: Throwable?) {
                    val stored = ModelStorage.getCommissionFromStorage(context)
                    if (stored != null && callback != null) {
                        callback(stored, null)
                    } else if (callback != null) {
                        callback(null, t)
                    }
                }

                override fun onResponse(call: Call<List<Profile>>?, response: Response<List<Profile>>?) {
                    val currentCommission = response?.body()
                    commission = currentCommission
                    if (currentCommission != null) {
                        ModelStorage.saveCommissionToStorage(context, currentCommission)
                    }
                    if (callback != null) callback(response?.body(), null)
                }
            })
        }
    }

    fun getEvaluations(context: Context, callback: ((List<Evaluations>?, Throwable?) -> Unit)?) {
        if (evaluations != null) {
            if (callback != null) {
                callback(evaluations, null)
            }
        } else {
            val callResponse = api.getEvaluations()
            callResponse.enqueue(object : Callback<List<Evaluations>> {
                override fun onFailure(call: Call<List<Evaluations>>?, t: Throwable?) {
                    val stored = ModelStorage.getEvaluationsFromStorage(context)
                    if (stored != null && callback != null) {
                        callback(stored, null)
                    } else if (callback != null) {
                        callback(null, t)
                    }
                }

                override fun onResponse(call: Call<List<Evaluations>>?, response: Response<List<Evaluations>>?) {
                    val currentEvaluations = response?.body()
                    evaluations = currentEvaluations
                    if (currentEvaluations != null) {
                        ModelStorage.saveEvaluationsToStorage(context, currentEvaluations)
                    }
                    if (callback != null) callback(evaluations, null)
                }
            })
        }
    }


    fun getEvaluationFor(context: Context, commissionPerson: Profile, callback: (List<EvaluationResult>?) -> Unit) {
        getCandidates(context) { _, _ ->
            getCommission(context) { _, _ ->
                getEvaluations(context) { _, _ ->
                    callback(findEvaluation(context, commissionPerson))
                }
            }
        }
    }

    private fun findEvaluation(context: Context, commissionPerson: Profile): List<EvaluationResult>? {
        val evaluations = evaluations ?: ModelStorage.getEvaluationsFromStorage(context) ?: return null
        val candidates = candidates ?: ModelStorage.getCandidatesFromStorage(context) ?: return null

        val profileIdList = HashMap<String, String>()
        evaluations
                .filter { it.postuladorId == commissionPerson.id }
                .forEach { profileIdList.put(it.perfilId!!, it.resultado!!) }
        val resultList = ArrayList<EvaluationResult>()
        for (profile in candidates) {
            val score = profileIdList[profile.id]
            if (score != null) {
                resultList.add(EvaluationResult(profile, score))
            }
        }
        return resultList
    }

}

