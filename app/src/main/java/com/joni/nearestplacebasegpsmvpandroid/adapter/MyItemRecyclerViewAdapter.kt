package com.joni.nearestplacebasegpsmvpandroid.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.joni.nearestplacebasegpsmvpandroid.R
import com.joni.nearestplacebasegpsmvpandroid.model.ResultsItem
import com.squareup.picasso.Picasso


import kotlinx.android.synthetic.main.fragment_item.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val mValues: List<ResultsItem>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView.text = item.name
        holder.mContentView.text = item.rating.toString()
        Picasso.get()
            .load("https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference="+ item.photos?.get(0)?.photoReference+"&key=AIzaSyAWJgZTtBhJSDAqiTwIFJeYIDQ7Ym-I_YQ")
            .error(R.drawable.ic_launcher_background).into(holder.gambar)

    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content
        val gambar : ImageView= mView.gambar

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
