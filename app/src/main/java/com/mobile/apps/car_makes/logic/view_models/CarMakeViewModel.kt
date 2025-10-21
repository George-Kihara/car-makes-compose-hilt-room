package com.mobile.apps.car_makes.logic.view_models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.apps.car_makes.logic.models.CarMake
import com.mobile.apps.car_makes.logic.repositories.CarMakeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarMakeViewModel @Inject constructor(
    private val repository: CarMakeRepository
) : ViewModel() {

    var carMakes by mutableStateOf<List<CarMake>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            carMakes = repository.getCarMakes()
        }
    }
}