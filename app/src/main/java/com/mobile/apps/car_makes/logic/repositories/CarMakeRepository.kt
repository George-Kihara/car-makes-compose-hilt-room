package com.mobile.apps.car_makes.logic.repositories

import android.net.ConnectivityManager
import com.mobile.apps.car_makes.logic.daos.CarMakeDao
import com.mobile.apps.car_makes.logic.interfaces.VpicApiService
import com.mobile.apps.car_makes.logic.models.CarMake
import javax.inject.Inject

class CarMakeRepository @Inject constructor(
    private val api: VpicApiService,
    private val dao: CarMakeDao,
    private val connectivity: ConnectivityManager
) {
    suspend fun getCarMakes(): List<CarMake> {
        return if (isNetworkAvailable()) {
            val response = api.getAllMakes()
            val makes = response.results
            dao.insertAll(makes)
            makes
        } else {
            dao.getAllMakes()
        }
    }

    private fun isNetworkAvailable(): Boolean {
        return connectivity.activeNetwork != null
    }
}