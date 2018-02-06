package eleccionmp.redciudadana.org.eleccionmp.http

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import eleccionmp.redciudadana.org.eleccionmp.utils.Storage

/**
 * Created by javier on 2/5/18.
 */

object ModelStorage {
    private fun getProfileListFromStorage(context: Context, key: String): List<Models.Profile>? {
        val type = Types.newParameterizedType(List::class.java, Models.Profile::class.java)
        val adapter = Moshi.Builder().build().adapter<List<Models.Profile>>(type)
        val stored = Storage.getStringPreference(context, key) ?: return null
        return adapter.fromJson(stored)
    }

    private fun saveProfileListToStorage(context: Context, key: String, profileList: List<Models.Profile>) {
        val type = Types.newParameterizedType(List::class.java, Models.Profile::class.java)
        val adapter = Moshi.Builder().build().adapter<List<Models.Profile>>(type)
        Storage.setStringPreference(context, key, adapter.toJson(profileList))
    }

    fun getEvaluationsFromStorage(context: Context): List<Models.Evaluations>? {
        val type = Types.newParameterizedType(List::class.java, Models.Evaluations::class.java)
        val adapter = Moshi.Builder().build().adapter<List<Models.Evaluations>>(type)
        val stored = Storage.getStringPreference(context, "evaluations") ?: return null
        return adapter.fromJson(stored)
    }

    fun saveEvaluationsToStorage(context: Context, evaluationList: List<Models.Evaluations>) {
        val type = Types.newParameterizedType(List::class.java, Models.Evaluations::class.java)
        val adapter = Moshi.Builder().build().adapter<List<Models.Evaluations>>(type)
        Storage.setStringPreference(context, "evaluations", adapter.toJson(evaluationList))
    }

    fun getCandidatesFromStorage(context: Context): List<Models.Profile>? {
        return getProfileListFromStorage(context, "candidates")
    }

    fun saveCandidatesToStorage(context: Context, profileList: List<Models.Profile>) {
        saveProfileListToStorage(context, "candidates", profileList)
    }

    fun getCommissionFromStorage(context: Context): List<Models.Profile>? {
        return getProfileListFromStorage(context, "commission")
    }

    fun saveCommissionToStorage(context: Context, profileList: List<Models.Profile>) {
        saveProfileListToStorage(context, "commission", profileList)
    }




}