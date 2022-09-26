package com.example.cryptoapp.domain.use_case.get_conis

import com.example.cryptoapp.domain.model.Coin
import com.example.cryptoapp.domain.repository.CoinRepository
import com.example.cryptoapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        emit(Resource.Loading())
        val result = repository.getCoins()
        emit(result)
    }
}