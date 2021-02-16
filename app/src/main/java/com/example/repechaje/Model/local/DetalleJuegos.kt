package com.example.repechaje.Model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "detallejuegos_table")
    data class DetalleJuegos(
        @PrimaryKey @NotNull val id: Int,
        val name: String,
        val backgroundImage: String,
        val delivery: Boolean,
        val lastPrice: Int,
        val platforms: String,
        val playtime: Int,
        val price: Int
    )
