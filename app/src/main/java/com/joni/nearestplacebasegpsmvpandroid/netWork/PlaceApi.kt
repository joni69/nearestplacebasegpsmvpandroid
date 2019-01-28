package com.joni.nearestplacebasegpsmvpandroid.netWork

import com.joni.nearestplacebasegpsmvpandroid.model.ResultPlace
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceApi {
    @GET("nearbysearch/json")
    fun ambil(
        @Query("location") location: String,
        @Query("tyoe") type: String,
        @Query("keyword") keyword: String,
        @Query("radius") radius: String,
        @Query("key") key: String
    ): Call<ResultPlace>

//    @FormUrlEncoded
//    @POST("nearbysearch/json")
//    fun simpan(
//        @Query("location") location: String,
//        @Query("tyoe") type: String,
//        @Query("keyword") keyword: String,
//        @Query("radius") radius: String,
//        @Query("key") key: String
//    ) :Call<ResultPlace>

}