package com.example.zitrocrm.navigation

sealed class Destination(val route: String){
    object SplashScreen : Destination(route = "splash_screen")
    object LoginScreen : Destination(route = "login_screen")
    object HomeScreen : Destination(route = "home_screen")
    object FilterScreen : Destination(route = "filter_screen")
    object SalasScreen : Destination(route = "salas_screen")
    object PromotorNewScreen : Destination(route = "promotor_new_screen")
    object PromotorReportScreen : Destination(route = "promotor_report_screen")

    companion object {
        fun getStartDestination() = SplashScreen.route
    }
}