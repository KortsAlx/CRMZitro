package com.example.zitrocrm.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zitrocrm.MainActivity
import com.example.zitrocrm.repository.DataStorePreferenceRepository
import com.example.zitrocrm.screens.*
import com.example.zitrocrm.screens.homepage.components.FilterScreen
import com.example.zitrocrm.screens.salas.PromotorNewScreen
import com.example.zitrocrm.screens.salas.PromotorNuevaVisita.PromotorNuevaVisitaViewModel
import com.example.zitrocrm.viewmodel.LoginViewModel
import kotlin.coroutines.coroutineContext


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationScreen(){
    val loginViewModel: LoginViewModel = viewModel()
    val viewModelPromotorNuevaVisita: PromotorNuevaVisitaViewModel = viewModel()
    val navController = rememberNavController()

    val loadingProgressBar = loginViewModel.progressBar.value
    val imageError = loginViewModel.imageErrorAuth.value


    NavHost(
        navController = navController,
        startDestination = Destination.getStartDestination()
    ) {

        composable(route = Destination.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(route = Destination.LoginScreen.route) {
            if (loginViewModel.isSuccessLoading.value) {
                LaunchedEffect(key1 = Unit) {
                    navController.navigate(route = Destination.HomeScreen.route) {
                        popUpTo(route = Destination.LoginScreen.route) {
                            inclusive = true
                        }
                    }
                }
            } else {
                LoginScreen(
                    loadingProgressBar = loadingProgressBar,
                    onclickLogin = loginViewModel::login,
                    imageError = imageError
                )
            }
        }
        composable(route = Destination.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(route = Destination.FilterScreen.route){
            FilterScreen(navController)
        }
        composable(route = Destination.SalasScreen.route){
            SalasScreen(navController)
        }
        composable(route = Destination.PromotorNewScreen.route){
            PromotorNewScreen(navController, viewModelPromotorNuevaVisita)
        }
        composable(route = Destination.PromotorReportScreen.route){
            PromotorReportScreen(navController)
        }
    }
}