package com.example.repechaje.Model

import android.util.Log
import com.example.repechaje.Model.local.DetalleJuegos
import com.example.repechaje.Model.local.JuegosDao
import com.example.repechaje.Model.pojos.Detalle
import com.example.repechaje.Model.remoto.RetrofitCliente
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JuegosRepository (private val mjuegoDao: JuegosDao){

    private val retroService = RetrofitCliente.getRetrofitClient()
    val alljuegosLiveData = mjuegoDao.showAllDetalleJuegos()

    //La vieja confiable
    fun getDataFromServer() {
        val call = retroService.fetchAllDetalles()
        call.enqueue(object : Callback<List<Detalle>> {
            override fun onResponse(call: Call<List<Detalle>>, response: Response<List<Detalle>>) {
                when (response.code()) {
                    in 200..299 -> {
                        Log.d("RESPONSE", response.body().toString())
                        CoroutineScope(Dispatchers.IO).launch {
                            response.body()?.let {
                                mjuegoDao.insertAllDetalleJuegos(convertjuegos(it))
                            }
                        }

                    }
                    in 300..599 -> Log.d("RESPONSE", response.errorBody().toString())
                    else -> Log.d("ERROR", response.errorBody().toString())

                }
            }

            override fun onFailure(call: Call<List<Detalle>>, t: Throwable) {

            }
        })
    }
        fun convertjuegos(ListFormNetwork: List<Detalle>): List<DetalleJuegos> {
            val listMutable = mutableListOf<DetalleJuegos>()
            ListFormNetwork.map {
                listMutable.add(DetalleJuegos(it.id,
                        it.name,
                        it.backgroundImage,
                        it.delivery,
                        it.lastPrice,
                        it.platforms,
                    it.playtime,
                    it.price
                    )
                )
            }
            return listMutable

        }
    }