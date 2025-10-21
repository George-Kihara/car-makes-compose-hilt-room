package com.mobile.apps.car_makes.logic.app_modules

import android.content.Context
import androidx.room.Room
import com.mobile.apps.car_makes.logic.daos.CarMakeDao
import com.mobile.apps.car_makes.logic.interfaces.VpicApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApi(): VpicApiService = Retrofit.Builder()
        .baseUrl("https://vpic.nhtsa.dot.gov/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(VpicApiService::class.java)

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "car_makes_db"
    )

    @Provides
    fun provideDao(db: AppDatabase): CarMakeDao = db.carMakeDao()
}