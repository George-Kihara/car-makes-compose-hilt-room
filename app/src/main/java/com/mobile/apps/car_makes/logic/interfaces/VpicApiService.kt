package com.mobile.apps.car_makes.logic.interfaces

import com.mobile.apps.car_makes.logic.models.VpicResponse
import retrofit2.http.GET

interface VpicApiService {

    @GET("vehicles/getallmakes?format=json")
    suspend fun getAllMakes(): VpicResponse

}