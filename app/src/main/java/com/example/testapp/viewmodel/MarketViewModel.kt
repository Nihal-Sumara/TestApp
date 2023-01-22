package com.example.testapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.testapp.model.BaseViewModel
import com.example.testapp.model.MarketDataClass
import com.example.testapp.repository.MarketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarketViewModel
@Inject
constructor(
    private val marketRepository: MarketRepository,
) : BaseViewModel() {
    var mutableMarketList = MutableLiveData<ArrayList<MarketDataClass.Market>>()

    fun getAllMarket() {
        showProgressbar()
        viewModelScope.launch {
            try {
                marketRepository.getAllMarket().let {
                    hideProgressbar()
                    if (it.isSuccessful) {
                        mutableMarketList.postValue(it.body()?.markets)
                    }
                }
            } catch (e: Exception) {
                hideProgressbar()
            }
        }
    }

}
























