package com.example.pocketchef.features.ingredients.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pocketchef.core.extension.toIngredientListItem
import com.example.pocketchef.features.ingredients.domain.usecases.GetCurrentIngredientsUseCase
import com.example.pocketchef.features.ingredients.presentation.models.IngredientsListItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class IngredientsViewModel @Inject constructor (
    private val getCurrentIngredientsUseCase: GetCurrentIngredientsUseCase,
) : ViewModel() {

    private val _currentIngredientsLoaded: MutableLiveData<List<IngredientsListItem>> = MutableLiveData<List<IngredientsListItem>>()
    val currentIngredientsLoaded: LiveData<List<IngredientsListItem>> get() = _currentIngredientsLoaded

    fun getCurrentIngredients() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val currentIngredients = getCurrentIngredientsUseCase.execute()
                withContext(Dispatchers.Main) {
                    _currentIngredientsLoaded.value = currentIngredients.map {
                        it.toIngredientListItem()
                    }
                }
            }
        }
    }
}