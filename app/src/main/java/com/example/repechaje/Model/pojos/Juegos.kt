package com.example.repechaje.Model.pojos


import com.google.gson.annotations.SerializedName

data class Juegos(
    @SerializedName("background_image")
    val backgroundImage: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("metacritic")
    val metacritic: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("released")
    val released: String
)