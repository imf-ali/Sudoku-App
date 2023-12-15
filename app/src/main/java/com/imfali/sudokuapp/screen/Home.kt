package com.imfali.sudokuapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.imfali.sudokuapp.data.Level
import com.imfali.sudokuapp.data.SudokuViewModel
import com.imfali.sudokuapp.ui.theme.ButtonBlue

@Composable
fun HomeScreen(navController: NavHostController, viewModel: SudokuViewModel) {
  val level: List<Level> = listOf(Level.EASY, Level.MEDIUM, Level.HARD)
  Column(
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      modifier = Modifier
        .padding(top = 25.dp, start = 15.dp)
        .align(alignment = Alignment.Start),
      text = "Sudoku",
      fontSize = 30.sp,
      fontWeight = FontWeight.Bold
    )
    Text(
      modifier = Modifier
        .padding(top = 130.dp, bottom = 20.dp)
        .align(alignment = Alignment.CenterHorizontally),
      color = ButtonBlue,
      fontSize = 20.sp,
      fontWeight = FontWeight.Bold,
      text = "New Game"
    )
    LazyColumn(
      horizontalAlignment = Alignment.CenterHorizontally
    ){
      items(level) {
        OutlinedButton(
          modifier= Modifier
            .width(200.dp),
          shape = RoundedCornerShape(10.dp),
          onClick = {
            viewModel.generateSudokuBoard(it)
            navController.navigate(Screen.GameScreen.route)
          }
        ) {
          Text(
            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
            text = it.name,
            fontWeight = FontWeight.Bold,
            color = Color.Black
          )
        }
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
      }
    }
    if(viewModel.sudoku.value.isInitialized){
      Spacer(modifier = Modifier.padding(top = 30.dp))
      Button(
        modifier= Modifier
          .width(200.dp)
          .padding(top = 10.dp, bottom = 10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(ButtonBlue),
        onClick = {
          navController.navigate(Screen.GameScreen.route)
        }
      ) {
        Text(
          modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
          color = Color.White,
          text = "Continue",
          fontWeight = FontWeight.Bold
        )
      }
    }
  }
}
