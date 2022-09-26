package com.example.cryptoapp.di

import com.example.cryptoapp.data.remote.CoinPaprikaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinPaprikaApi(): CoinPaprikaApi {
        return Retrofit
            .Builder()
            .baseUrl("https://api.coinpaprika.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }
}