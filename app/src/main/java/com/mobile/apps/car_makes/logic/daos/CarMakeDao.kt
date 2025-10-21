package com.mobile.apps.car_makes.logic.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mobile.apps.car_makes.logic.models.CarMake

@Dao
interface CarMakeDao {
    @Query("SELECT * FROM car_makes")
    suspend fun getAllMakes(): List<CarMake>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(makes: List<CarMake>)
}