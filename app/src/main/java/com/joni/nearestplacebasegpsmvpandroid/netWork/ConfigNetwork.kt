package com.joni.nearestplacebasegpsmvpandroid.netWork

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConfigNetwork {
    fun getRetrofit():Retrofit{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://maps.googleapis.com/maps/api/place/")
            .client(GetInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    fun GetInterceptor():OkHttpClient{
        val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return  client
    }
    fun getService():PlaceApi{
        return  getRetrofit().create(PlaceApi::class.java)
    }
}