package com.example.repechaje.Model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DetalleJuegos::class],version = 1)
abstract class JuegosDatabase: RoomDatabase() {

    abstract fun juegosDao(): JuegosDao
    companion object{  //permite acceder a el sin necesidad de crear el objeto de la clase, nombre clase + punto y acceso a lo que está en el companen objet
        @Volatile
        private var INSTANCE:JuegosDatabase?= null
        fun getDataBase(context: Context): JuegosDatabase{

            val tempInstance= INSTANCE
            if(tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(context,
                    JuegosDatabase::class.java,
                    "nombreBD")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}