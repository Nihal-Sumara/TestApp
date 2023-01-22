package com.example.testapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.testapp.R
import com.example.testapp.databinding.ItemMarketBinding
import com.example.testapp.model.MarketDataClass

class MarketAdapter(var list: ArrayList<MarketDataClass.Market>) :
    RecyclerView.Adapter<MarketAdapter.MarketItemViewHolder>()
/*PagingDataAdapter<MarketDataClass.Market, MarketAdapter.MarketItemViewHolder>(diffCallback)*/ {

    private var limit = 10
    var num = 1
    var onItemClick: ((position: Int) -> Unit)? = null

    inner class MarketItemViewHolder(var binding: ItemMarketBinding) : ViewHolder(binding.root) {
        fun bind(data: MarketDataClass.Market) = binding.apply {
            mData = data
            this.ivFav.setOnClickListener {
                onItemClick!!.invoke(bindingAdapterPosition)
            }
            executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketItemViewHolder {
        return MarketItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_market,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MarketItemViewHolder, position: Int) {
        holder.bind(list[position])
        if (position == list.size - 1) {
            holder.binding.view.visibility = View.GONE
        }
        holder.itemView.setOnClickListener {
//            onItemClick!!.invoke(position)
//            holder.binding.ivFav.setImageResource(R.drawable.ic_favorite_solid)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}