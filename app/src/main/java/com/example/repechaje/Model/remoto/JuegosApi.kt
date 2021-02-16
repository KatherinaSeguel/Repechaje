package com.example.repechaje.Model.remoto

import com.example.repechaje.Model.pojos.Detalle
import com.example.repechaje.Model.pojos.Juegos
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface JuegosApi {

    //la vieja confiable Juegos
    @GET("games")
    fun fetchAllJuegos (): Call<List<Juegos>>
    //con courroutinas
    @GET("games")
    suspend fun fetchAllJuegoswithCourrutinas (): Response<List<Juegos>>


    //la vieja confiable Detalles
    @GET("gameDetails/4200")
    fun fetchAllDetalles (): Call<List<Detalle>>
    //con courroutinas
    @GET("gameDetails/4200")
    suspend fun fetchAllDetalleswithCourrutinas (): Response<List<Detalle>>

}