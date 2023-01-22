//package com.example.testapp.paging
//
//import android.util.Log
//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import com.example.testapp.api.ApiService
//import com.example.testapp.model.MarketDataClass
//
//class MarketPagingSource(private val apiService: ApiService) : PagingSource<Int, MarketDataClass.Market>() {
//
//    override fun getRefreshKey(state: PagingState<Int, MarketDataClass.Market>): Int? {
//        return null
//    }
//
//    override suspend fun load(params: LoadParams<Int>):
//            LoadResult<Int, MarketDataClass.Market> {
//
//        return try {
//            val currentPage = params.key ?: 1
//            val response = apiService.getAllMarket()
//            val responseData = mutableListOf<MarketDataClass.Market>()
//            val data = response.body()?.markets ?: emptyList()
//            val sortedList = data.sortedBy {
//                it.price
//            }
//            responseData.addAll(sortedList)
//
//            LoadResult.Page(
//                data = responseData,
//                prevKey = if (currentPage == 1) null else -1,
//                nextKey = currentPage.plus(1)
//            )
//        } catch (e: Exception) {
//            LoadResult.Error(e)
//        }
//
//    }
//}