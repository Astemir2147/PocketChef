package com.example.pocketchef.features.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {


    /**
     * Выполняет проверку авторизован ли пользователь
     */
    fun checkLogined() {
        // viewModelScope.launch {
        //     if (loginInteracts.checkIfAuthentificated()) {
        //         mutableLoginAttemptResultLiveData.value = true
        //     }
        // }
    }

}