package com.mobile.apps.car_makes.logic.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "car_makes")
data class CarMake(
    @PrimaryKey @SerializedName("Make_ID") val makeId: Int,
    @SerializedName("Make_Name") val makeName: String
)

data class VpicResponse(
    @SerializedName("Results") val results: List<CarMake>
)
