package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.remote.dto.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path


interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun fetchCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun fetchCoinById(@Path("coinId") coinId: String): CoinDetailDto
}