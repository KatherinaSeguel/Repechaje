package com.example.repechaje.Model.remoto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitCliente {

    companion object{

        private const val  URL_BASE = "https://my-json-server.typicode.com/himuravidal/gamesDB/"


        fun getRetrofitClient(): JuegosApi {

            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return  mRetrofit.create(JuegosApi::class.java) // devuelve la unión de la Interface con el cliente retrofit

        }
    }
}