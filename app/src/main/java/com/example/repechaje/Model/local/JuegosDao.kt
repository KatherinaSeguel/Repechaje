package com.example.repechaje.Model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface JuegosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDetalleJuegos (mList: List<DetalleJuegos>)

    @Query("SELECT * FROM detallejuegos_table")
    fun showAllDetalleJuegos(): LiveData<List<DetalleJuegos>>

    //para buscar uno específico
    @Query("SELECT * FROM detallejuegos_table WHERE id=:mId")
    fun ShowOnDetalleJuegosByID(mId:Int): LiveData<DetalleJuegos>
}