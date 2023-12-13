package com.imfali.sudokuapp

import androidx.compose.runtime.Composable
import com.imfali.sudokuapp.data.SudokuViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.imfali.sudokuapp.screen.HomeScreen
import com.imfali.sudokuapp.screen.Screen
import com.imfali.sudokuapp.screen.Sudoku

@Composable
fun Navigation(
  viewModel: SudokuViewModel = viewModel(),
  navController: NavHostController = rememberNavController()
){
  NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
    composable(Screen.HomeScreen.route){
      HomeScreen(navController, viewModel)
    }
    composable(Screen.GameScreen.route){
      Sudoku(navController, viewModel)
    }
  }
}