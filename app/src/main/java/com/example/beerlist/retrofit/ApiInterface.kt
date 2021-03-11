package com.example.beerlist.retrofit

import com.example.beerlist.model.BeerData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    //https://api.punkapi.com/v2/beers

    @GET("beers")
    fun getPhotos(): Call<List<BeerData>>
}