package com.example.airbnb

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.airbnb.databinding.ItemFacilitiesDetailBinding

class DetailFacilitiesRVAdapter() :
    RecyclerView.Adapter<DetailFacilitiesRVAdapter.ViewHolder>() {
    private val facilities =ArrayList<Facility>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): DetailFacilitiesRVAdapter.ViewHolder {
        val binding: ItemFacilitiesDetailBinding = ItemFacilitiesDetailBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailFacilitiesRVAdapter.ViewHolder, position: Int) {
        holder.bind(facilities[position])

    }

    override fun getItemCount(): Int = facilities.size


    @SuppressLint("NotifyDataSetChanged")
    fun addFacilities(facilities: java.util.ArrayList<Facility>){
        this.facilities.clear()           //??
        this.facilities.addAll(facilities)

        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemFacilitiesDetailBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(facility: Facility) {
            binding.itemFacilitiesImgIv.setImageResource(facility.coverImg!!)
            binding.itemFacilitiesTitleTv.text = facility.content
        }
    }

}