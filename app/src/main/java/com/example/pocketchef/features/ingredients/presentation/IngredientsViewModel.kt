package com.example.pocketchef.features.ingredients.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IngredientsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is ingredients Fragment"
    }
    val text: LiveData<String> = _text
}