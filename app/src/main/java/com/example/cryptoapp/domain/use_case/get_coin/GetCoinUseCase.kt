package com.example.cryptoapp.domain.use_case.get_coin

import com.example.cryptoapp.domain.model.CoinDetail
import com.example.cryptoapp.domain.repository.CoinRepository
import com.example.cryptoapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        emit(Resource.Loading())
        val coinDetailResource = repository.getCoinById(coinId = coinId)
        emit(coinDetailResource)
    }
}