package com.joni.nearestplacebasegpsmvpandroid.presenter

import com.joni.nearestplacebasegpsmvpandroid.model.ResultsItem

interface Placeview {
    fun onResult(data: List<ResultsItem>)
    fun onError()
}