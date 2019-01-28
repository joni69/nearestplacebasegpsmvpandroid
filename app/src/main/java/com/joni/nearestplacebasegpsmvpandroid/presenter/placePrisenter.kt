package com.joni.nearestplacebasegpsmvpandroid.presenter

import android.util.Log.d
import com.joni.nearestplacebasegpsmvpandroid.model.ResultPlace
import com.joni.nearestplacebasegpsmvpandroid.model.ResultsItem
import com.joni.nearestplacebasegpsmvpandroid.netWork.ConfigNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class placePrisenter(val placeview: Placeview) {
    fun loadData(location: String, type: String, keyword: String, key: String) {
        ConfigNetwork.getService().ambil(location, type, keyword, "5000", key)
            .enqueue(object : Callback<ResultPlace> {
                override fun onFailure(call: Call<ResultPlace>, t: Throwable) {
                    d("eroor",t.message)

                }

                override fun onResponse(call: Call<ResultPlace>, response: Response<ResultPlace>) {
                    if (response.isSuccessful) {
                        val data = response.body()?.results
                        placeview.onResult(data as List<ResultsItem>)
                        d("berha",data.toString())
                    } else {
                        placeview.onError()
                    }

                }

            })
    }
}