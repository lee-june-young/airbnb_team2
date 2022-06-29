package com.example.airbnb

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.airbnb.databinding.ItemAccommodationsBinding

class IslandRVAdapter : RecyclerView.Adapter<IslandRVAdapter.ViewHolder>() {

    var datas = mutableListOf<IslandData>()

    inner class ViewHolder(val binding : ItemAccommodationsBinding) : RecyclerView.ViewHolder(binding.root){

        val coverImg : ImageView = binding.itemAccommodationCoverImgIv
        val place : TextView = binding.itemAccommodationPlaceTv
        val distance : TextView = binding.itemAccommodationDistanceTv
        val date : TextView = binding.itemAccommodationDateTv
        val price : TextView = binding.itemAccommodationPriceTv

        fun bind(item: IslandData) {
            //viewpager만들고 item.coverImg[position]
            Glide.with(itemView).load(item.coverImg?.get(0)).into(coverImg)
            place.text = item.place
            distance.text = item.distance
            date.text = item.date
            price.text = "${item.price}" //or toString()
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemAccommodationsBinding = ItemAccommodationsBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    override fun getItemCount(): Int = datas.size
}