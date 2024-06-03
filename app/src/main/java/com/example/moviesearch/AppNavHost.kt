package com.example.moviesearch

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController()
){
    NavHost(navController = navController, startDestination = "home_screen"){

        composable(route = "home_screen"){
            HomeScreen(
                onNavigateToResultScreen = {
                    navController.navigate("result_screen/$it")}
            )
        }

        composable(
            route = "result_screen/{inputName}",
            arguments = listOf(
                    navArgument("inputName"){
                        type = NavType.StringType
                    }
            )
        ){
            ResultScreen(
                onNavigateToHomeScreen = {
                    navController.navigate("home_screen")},
                onNavigateToMovieScreen = {
                    navController.navigate("movie_screen")},
                textToDisplay = it.arguments?.getString("inputName").toString())

        }
        composable(route = "movie_screen"){
            MovieScreen(
                onNavigateBackToResultScreen = {
                    navController.navigate("result_screen/$it")}
            )

        }
    }
}