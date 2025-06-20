package com.example.week07b.example02.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.week07b.example02.model.Routes
import com.example.week07b.example02.uicomponents.LoginScreen
import com.example.week07b.example02.uicomponents.Register
import com.example.week07b.example02.uicomponents.WelcomeScreen


@Composable
fun LoginNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.Login.route) {
        composable(route = Routes.Login.route) {
            LoginScreen(
                onWelcomeNavigate = { userId ->
                    navController.navigate(Routes.Welcome.route + "/$userId")
                },
                onRegisterNavigate = { userId, userPassword ->
                    if (userId.isNotEmpty() || userPassword.isNotEmpty())
                        navController.navigate(
                            Routes.Register.route
                                    + "?userId=$userId&passWD=$userPassword"
                        )
                    else
                        navController.navigate(Routes.Register.route)
                }
            )
        }

        composable(
            route = Routes.Welcome.route + "/{userId}",
            arguments = listOf(
                navArgument(name = "userId") {
                    type = NavType.StringType
                }
            )
        ) {
            WelcomeScreen(
                it.arguments?.getString("userId")
            )
        }

        composable(
            route = Routes.Register.route + "?userId={userId}&passWD={passWD}",
            arguments = listOf(
                navArgument(name = "userId") {
                    type = NavType.StringType
                    defaultValue = "User"
                },
                navArgument(name = "passWD") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            Register(                       //전달된 값을 getString으로 꺼내서 Register함수에 전달
                it.arguments?.getString("userId"),
                it.arguments?.getString("passWD")
            )
        }
    }
}