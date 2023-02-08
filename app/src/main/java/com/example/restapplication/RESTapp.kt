package com.example.restapplication

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.restapplication.ui.screens.AppViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.restapplication.ui.screens.homeScreen

enum class Screen{
    Home()
}


@Composable
fun restApp(
    viewModel: AppViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){

    //State info viewModel
    val uiState by viewModel.uiState.collectAsState()

    //Navigation
    NavHost(navController = navController, startDestination = Screen.Home.name){
        composable(route = Screen.Home.name){
            homeScreen(uiState.users)
        }
    }

}