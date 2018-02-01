package eleccionmp.redciudadana.org.eleccionmp.http

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by javier on 1/15/18.
 */

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
        val notaAreaEvaluada1: Int?,
        val notaAreaEvaluada2: Int?,
        val notaAreaEvaluada3: Int?,
        val notaAreaEvaluada4: Int?,
        val sexo: String?,
        val estado: String?,
        val fb: String?,
        val tw: String?,
        val email: String?,
        val fbInstitucion: String?,
        val twInstitucion: String?,
        val emailInstitucion: String?,
        val fotoUrl: String?,
        val telefono: String?,
        val direccion: String?,
        val web: String
) : Parcelable

