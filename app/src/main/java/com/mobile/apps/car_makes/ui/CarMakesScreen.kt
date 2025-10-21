package com.mobile.apps.car_makes.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.mobile.apps.car_makes.logic.view_models.CarMakeViewModel
import dagger.hilt.android.AndroidEntryPoint

@Composable
fun CarMakesScreen() {

    val viewModel: CarMakeViewModel = hiltViewModel()

    val carMakes = viewModel.carMakes

    Column {

        LazyColumn {
            items(carMakes) { carMake ->
                Text(
                    text = carMake.makeName,
                    color = Color.Green,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun CarMakesScreenPreview() {
    CarMakesScreen()
}

@AndroidEntryPoint
class CarMakesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarMakesScreen()
        }
    }
}