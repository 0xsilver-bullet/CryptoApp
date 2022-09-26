package com.example.cryptoapp.data.repository

import com.example.cryptoapp.data.remote.CoinPaprikaApi
import com.example.cryptoapp.data.remote.dto.toCoin
import com.example.cryptoapp.data.remote.dto.toCoinDetail
import com.example.cryptoapp.domain.model.Coin
import com.example.cryptoapp.domain.model.CoinDetail
import com.example.cryptoapp.domain.repository.CoinRepository
import com.example.cryptoapp.utils.Resource
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): Resource<List<Coin>> {
        return try {
            Resource.Success(api
                .fetchCoins()
                .map { coinDto ->
                    coinDto.toCoin()
                }
            )
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Unexpected error")
        }
    }

    override suspend fun getCoinById(coinId: String): Resource<CoinDetail> {
        return try {
            Resource.Success(
                api
                    .fetchCoinById(coinId)
                    .toCoinDetail()
            )
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Unexpected Error")
        }
    }
}