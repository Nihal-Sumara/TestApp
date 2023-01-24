package com.example.testapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AbsListView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.adapter.MarketAdapter
import com.example.testapp.databinding.ActivityMainBinding
import com.example.testapp.model.MarketDataClass
import com.example.testapp.viewmodel.MarketViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var marketAdapter: MarketAdapter
    private val viewModel: MarketViewModel by viewModels()
    lateinit var manager: LinearLayoutManager
    var list = arrayListOf<MarketDataClass.Market>()
    var isScrolling: Boolean = false
    var currentItems: Int? = 0
    var totalItems: Int? = 0
    var scrolledOutItems: Int? = 0
    var lastVisibleItems: Int? = 0
    var favouriteList = ArrayList<MarketDataClass.Market>()
    var currentIndex = 0
    var pageSize = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        manager = LinearLayoutManager(this)
        loadData()
    }

    private fun setupRecyclerView() {
        marketAdapter = MarketAdapter(list)
        binding.rvMarket.adapter = marketAdapter
        binding.rvMarket.layoutManager = manager
        marketAdapter.onItemClick = { position ->
            favouriteList.add(list[position])
            Toast.makeText(this, "Added to favourite", Toast.LENGTH_SHORT).show()
        }
        binding.rvMarket.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
//                currentItems = manager.childCount
//                totalItems = manager.itemCount
                lastVisibleItems = manager.findLastCompletelyVisibleItemPosition()

//                scrolledOutItems = manager.findFirstVisibleItemPosition()
                if (isScrolling && (lastVisibleItems == 10)) {
                    isScrolling = false
                    loadData()
                }
            }
        })
    }

    private fun loadData() {
        viewModel.getAllMarket()
        viewModel.mProgressBar.observe(this) {
            if (it != null && it) {
                binding.progressBar.visibility = View.VISIBLE
            } else binding.progressBar.visibility = View.GONE
        }
        viewModel.mutableMarketList.observe(this) {
            if (!it.isNullOrEmpty()) {
                list.clear()
                list.addAll(it.sortedBy {
                    it.price
                })
                marketAdapter.notifyDataSetChanged()
            }
        }
        setupRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favourite -> {
                startActivity(
                    Intent(this, FavouriteActivity::class.java).putExtra(
                        "FAVOURITE_LIST",
                        favouriteList
                    )
                )
            }
        }
        return super.onOptionsItemSelected(item)
    }
}