package com.example.beerlist.model

import com.google.gson.annotations.SerializedName

data class BeerData(
    @SerializedName("name")      //맥주이름
    val name: String,
    @SerializedName("tagline")  //간단설명
    val tagline: String,
    @SerializedName("image_url") //이미지
    val image_url: String


)