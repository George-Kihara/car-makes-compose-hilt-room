package com.mobile.apps.car_makes.logic.dbs

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mobile.apps.car_makes.logic.daos.CarMakeDao
import com.mobile.apps.car_makes.logic.models.CarMake

@Database(entities = [CarMake::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun carMakeDao(): CarMakeDao
}