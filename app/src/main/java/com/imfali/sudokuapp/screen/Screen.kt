package com.imfali.sudokuapp.screen

sealed class Screen(val route: String){
  object HomeScreen: Screen("home")
  object GameScreen: Screen("game_screen")
}
