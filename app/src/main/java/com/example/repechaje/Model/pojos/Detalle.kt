package com.example.repechaje.Model.pojos


import com.google.gson.annotations.SerializedName

data class Detalle(
    @SerializedName("background_image")
    val backgroundImage: String,
    @SerializedName("delivery")
    val delivery: Boolean,
    @SerializedName("format")
    val format: String,
    @SerializedName("genres")
    val genres: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lastPrice")
    val lastPrice: Int,
    @SerializedName("metacritic")
    val metacritic: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("platforms")
    val platforms: String,
    @SerializedName("playtime")
    val playtime: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("released")
    val released: String
)