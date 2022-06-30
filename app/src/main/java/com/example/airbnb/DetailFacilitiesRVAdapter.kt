package com.example.airbnb

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.airbnb.databinding.ItemFacilitiesDetailBinding

class DetailFacilitiesRVAdapter() :
    RecyclerView.Adapter<DetailFacilitiesRVAdapter.ViewHolder>() {
    private val facilities =ArrayList<Int>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): DetailFacilitiesRVAdapter.ViewHolder {
        val binding: ItemFacilitiesDetailBinding = ItemFacilitiesDetailBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailFacilitiesRVAdapter.ViewHolder, position: Int) {
        holder.bind(facilities[position], position) // 유뮤여부, 위치

    }

    override fun getItemCount(): Int = facilities.size

    @SuppressLint("NotifyDataSetChanged")
    fun addFacilities(facilities: ArrayList<Int>) {
        this.facilities.clear()
        this.facilities.addAll(facilities)
        Log.d("rv",facilities.toString())
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemFacilitiesDetailBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(facility: Int, position: Int) {
            when(position){
                0->{ //wifi여부
                    if(facility==1){
                        binding.itemFacilitiesTitleTv.text="와이파이 있음"
                    }else{
                        binding.itemFacilitiesTitleTv.text="와이파이 없음"
                    }
                }
                1->{ //수영장 여부
                    if(facility==1){
                        binding.itemFacilitiesTitleTv.text="수영장 있음"
                    }else{
                        binding.itemFacilitiesTitleTv.text="수영장 없음"
                    }
                }
                2->{ //욕조 여부
                    if(facility==1){
                        binding.itemFacilitiesTitleTv.text="욕조 있음"
                    }else{
                        binding.itemFacilitiesTitleTv.text="욕조 없음"
                    }
                }
                3->{ //Tv여부
                    if(facility==1){
                        binding.itemFacilitiesTitleTv.text="Tv 있음"
                    }else{
                        binding.itemFacilitiesTitleTv.text="Tv 없음"
                    }
                }
                4->{ //부엌여부
                    if(facility==1){
                        binding.itemFacilitiesTitleTv.text="부엌 있음"
                    }else{
                        binding.itemFacilitiesTitleTv.text="부엌 없음"
                    }
                }

            }
        }
    }

}