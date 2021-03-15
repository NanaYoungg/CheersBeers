package com.example.beerlist.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    var BASE_URL: String = "https://api.punkapi.com/v2/"
    val getClient: ApiInterface
        get() {

            val gson = GsonBuilder()
                .setLenient()
                .create()

            //Http통신 로그 기록
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)                                       //네트워크 요청할 서버
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))  //어떤 Converter를 이용하여 데이터를 파싱할건지
                .build()                                                 //실질적으로 Retrofit 객체를 만들어 반환

            return retrofit.create(ApiInterface::class.java)

        }
}