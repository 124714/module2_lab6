package com.cfsuman.jetpack

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random
import kotlin.random.nextInt

class RandomNumberViewModel:ViewModel(){
    // Create a LiveData with a random number
    val currentRandomNumber:MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun random() {
        currentRandomNumber.value = Random.nextInt(0..50)
    }
}
