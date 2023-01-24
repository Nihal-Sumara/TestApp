package com.example.testapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.R
import com.example.testapp.adapter.MarketAdapter
import com.example.testapp.databinding.ActivityFavouriteBinding
import com.example.testapp.model.MarketDataClass

class FavouriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavouriteBinding
    private lateinit var marketAdapter: MarketAdapter
    private var list = ArrayList<MarketDataClass.Market>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)
        binding = ActivityFavouriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list.clear()
        list.addAll((intent.getParcelableArrayListExtra("FAVOURITE_LIST")!!))
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        marketAdapter = MarketAdapter(list)
        binding.rvFavourite.adapter = marketAdapter
    }
}