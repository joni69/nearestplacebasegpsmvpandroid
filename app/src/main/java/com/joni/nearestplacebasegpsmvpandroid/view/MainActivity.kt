package com.joni.nearestplacebasegpsmvpandroid.view

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log.d
import android.widget.Toast
import com.joni.nearestplacebasegpsmvpandroid.R
import com.joni.nearestplacebasegpsmvpandroid.adapter.MyItemRecyclerViewAdapter
import com.joni.nearestplacebasegpsmvpandroid.model.ResultsItem
import com.joni.nearestplacebasegpsmvpandroid.presenter.Placeview
import com.joni.nearestplacebasegpsmvpandroid.presenter.placePrisenter
import com.joni.nearestplacebasegpsmvpandroid.utils.GPSTracker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,Placeview{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter = placePrisenter(this)

        val gps = GPSTracker(this)
        if (gps.checkPermission(this)){

        }else{
//            request permissin manual
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION),2)
            }
        }

        if (gps.canGetLocation()){
            val lat = gps.latitude
            val lon = gps.longitude
            val location =  "$lat,$lon"
            presenter.loadData(location,"Mall","Mall",getString(R.string.key))
            Toast.makeText(this,location,Toast.LENGTH_SHORT).show()
        }

    }
    override fun onResult(data: List<ResultsItem>) {
        d("data",data.toString())
        recycle.adapter = MyItemRecyclerViewAdapter(data)
        recycle.layoutManager = LinearLayoutManager(this)


    }

    override fun onError() {

    }
}
