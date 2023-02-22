package com.example.beerapi.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beerapi.Network.ResponseBeerModel
import com.example.beerapi.Network.ResponseBeerModelItem
import com.example.beerapi.databinding.ItemLayoutBinding
import com.squareup.picasso.Picasso

class BeerAdapter(var context: Context, var mList: ArrayList<ResponseBeerModelItem>):RecyclerView.Adapter<BeerAdapter.BeerViewHolder>() {

  private lateinit var mListener: onItemClickListener

  interface onItemClickListener{
      fun onItemClick(position: Int)
  }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }


    class BeerViewHolder(var binding: ItemLayoutBinding, listener : onItemClickListener):RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

        fun bind(list: ResponseBeerModelItem){
            binding.tvName.text = list.name
            binding.tvTagline.text = list.tagline

            Picasso.get().load(list.image_url).into(binding.ivImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        var binding = ItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return BeerViewHolder(binding,mListener)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {

        val list = mList[position]
        holder.bind(list)
    }
}