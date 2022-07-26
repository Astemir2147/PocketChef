package com.example.pocketchef.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pocketchef.presentation.ui.HomeInteractorImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val loginInteracts: HomeInteractorImpl) : ViewModel() {
    private val mutableHomeLoginedResultLiveData = MutableLiveData<Boolean>()
    val homeLoginedResultLiveData: LiveData<Boolean>
        get() = mutableHomeLoginedResultLiveData
    /**
     * Выполняет проверку авторизован ли пользователь
     */
    fun checkLogined() {
        viewModelScope.launch {
            if (loginInteracts.checkIfAuthentificated()) {
                mutableHomeLoginedResultLiveData.value = true
            }
        }
    }
}