package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.domain.model.Coin
import com.example.cryptoapp.domain.model.CoinDetail
import com.example.cryptoapp.utils.Resource

interface CoinRepository {

    suspend fun getCoins(): Resource<List<Coin>>
    suspend fun getCoinById(coinId: String): Resource<CoinDetail>
}