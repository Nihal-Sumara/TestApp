package com.example.testapp.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Abhin.
 */
open class BaseViewModel() : ViewModel() {

    var mProgressBar = MutableLiveData<Boolean>()
    var mErrorMessageDialog = MutableLiveData("")

    fun showProgressbar() {
        mProgressBar.value = true
    }

    fun hideProgressbar() {
        mProgressBar.value = false
    }
}