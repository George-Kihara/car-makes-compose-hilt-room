package com.mobile.apps.car_makes.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.mobile.apps.car_makes.logic.view_models.CarMakeViewModel

@Composable
fun CarMakesScreen() {

    val viewModel: CarMakeViewModel = hiltViewModel()

    val carMakes = viewModel.carMakes

    LazyColumn {
        items(carMakes) { carMake ->
            Text(
                text = carMake.makeName,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}