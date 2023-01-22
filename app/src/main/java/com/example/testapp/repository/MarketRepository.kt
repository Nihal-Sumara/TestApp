package com.example.testapp.repository

import com.example.testapp.api.ApiService
import javax.inject.Inject

class MarketRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getAllMarket() = apiService.getAllMarket()
}