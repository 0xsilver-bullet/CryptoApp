package com.example.cryptoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cryptoapp.presentation.coin_list.CoinListScreen

@Composable
fun CryptoAppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.CoinListScreen.route
    ) {
        composable(Screen.CoinListScreen.route) {
            CoinListScreen(navController = navController)
        }
    }
}