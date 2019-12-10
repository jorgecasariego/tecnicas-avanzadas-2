package py.edu.uca.navigationcomponent.network

import py.edu.uca.navigationcomponent.model.PeliculaResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PeliculaApi {

    @GET("movie/{category}")
    fun getPeliculas(
        @Path("category") category: String,
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<PeliculaResult>

    companion object {
        val BASE_URL = "https://api.themoviedb.org/3/"

        fun create(): PeliculaApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(PeliculaApi::class.java)
        }
    }
}