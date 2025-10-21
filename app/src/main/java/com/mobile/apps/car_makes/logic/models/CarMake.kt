package com.mobile.apps.car_makes.logic.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "car_makes")
data class CarMake(
    @PrimaryKey val makeId: Int,
    val makeName: String
)
