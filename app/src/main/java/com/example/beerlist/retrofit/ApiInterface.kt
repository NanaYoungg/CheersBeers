package com.example.beerlist.retrofit

import com.example.beerlist.model.Beer
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("beers")
    fun getPhotos(): Call<List<Beer>>
}