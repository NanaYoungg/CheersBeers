package com.example.beerlist.model

import com.google.gson.annotations.SerializedName

data class Beer(
//    @SerializedName("albumId")
//    var albumId: kotlin.Int,
//    @SerializedName("id")
//    var id: kotlin.Int,
    @SerializedName("name")
    val name: String
//    @SerializedName("url")
//    val url: String,
//    @SerializedName("thumbnailUrl")
//    val thumbnailUrl: String
)