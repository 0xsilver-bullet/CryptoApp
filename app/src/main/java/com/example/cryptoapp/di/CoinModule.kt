package com.example.cryptoapp.di

import com.example.cryptoapp.data.repository.CoinRepositoryImpl
import com.example.cryptoapp.domain.repository.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CoinModule {

    @Binds
    @Singleton
    abstract fun bindCoinRepository(coinRepository: CoinRepositoryImpl): CoinRepository
}