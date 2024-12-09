package com.demo.foodbite.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.demo.foodbite.screens.ForgotPwdScreen
import com.demo.foodbite.screens.LoginScreen
import com.demo.foodbite.screens.MainScreen
import com.demo.foodbite.screens.RegisterScreen
import com.demo.foodbite.screens.SelectionScreen
import com.demo.foodbite.screens.SplashScreen

@Composable
fun NavControllerClass(){
    val navController = rememberNavController() // Create NavController
    // Set up navigation using NavHost
    NavHost(
        navController = navController,
        startDestination = "splash_screen"
    ){
        composable("splash_screen") {
            SplashScreen(navController = navController) // Correctly pass navController
        }

        //selection Screen
        composable("selection_screen") {
            SelectionScreen(navController)
        }

        //Login Screen
        composable("login_screen"){
            LoginScreen(navController)
        }

        //Register Screen
        composable("register_screen"){
            RegisterScreen(navController)
        }

        //Register Screen
        composable("forgot_pwd_screen"){
            ForgotPwdScreen(navController)
        }

        //Main Screen
        composable("main_screen"){
            MainScreen(navController)
        }


    }

}

