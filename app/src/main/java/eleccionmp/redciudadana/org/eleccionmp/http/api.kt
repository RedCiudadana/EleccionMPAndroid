package eleccionmp.redciudadana.org.eleccionmp.http

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/**
 * Created by javier on 1/15/18.
 */

val BASE_URL = "https://rawgit.com/RedCiudadana/EleccionMP/master/public/static-files/"

interface IApi {
    @GET("perfil.json")
    fun getProfiles() : Call<List<Profile>>


}


private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

var api = retrofit.create(IApi::class.java)