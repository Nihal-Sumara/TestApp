package com.example.testapp.api

import com.example.testapp.model.MarketDataClass
import com.example.testapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getAllMarket(): Response<MarketDataClass>
}