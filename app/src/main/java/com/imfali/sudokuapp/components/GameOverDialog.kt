package com.imfali.sudokuapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.imfali.sudokuapp.data.Level
import com.imfali.sudokuapp.data.SudokuViewModel
import com.imfali.sudokuapp.ui.theme.ButtonBlue

@Composable
fun GameOverDialog(navController: NavHostController, viewModel: SudokuViewModel) {
  val level = viewModel.sudoku.value.level
  val mistake = viewModel.sudoku.value.mistake
  val score = viewModel.sudoku.value.score

  val cellsToFill = if(level == Level.EASY) 30 else if(level == Level.MEDIUM) 40 else 50
  val gameDone = (score == cellsToFill * 10 - mistake.toInt() * 5)

  if(mistake == 3 || gameDone){
    Dialog(onDismissRequest = { }) {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .height(250.dp)
          .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
      ) {
        Column(
          modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(
            text = if (gameDone) "CONGRATULATIONS" else "GAME OVER",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
          )
          Spacer(modifier = Modifier.padding(top = 5.dp))
          Text(text = if (gameDone) "You solved the puzzle!" else "You made 3 mistakes")
          Spacer(modifier = Modifier.padding(top = 25.dp))
          Row {
            Button(
              shape = RoundedCornerShape(10.dp),
              colors = ButtonDefaults.buttonColors(ButtonBlue),
              onClick = {
                viewModel.generateSudokuBoard(level)
              }
            ) {
              Text(
                text = "Restart",
                textAlign = TextAlign.Center
              )
            }
            Spacer(modifier = Modifier.padding(start = 15.dp, end = 15.dp))
            Button(
              shape = RoundedCornerShape(10.dp),
              colors = ButtonDefaults.buttonColors(ButtonBlue),
              onClick = {
                viewModel.dismissBoard()
                navController.navigateUp()
              }
            ) {
              Text(
                text = "Go Back",
                textAlign = TextAlign.Center
              )
            }
          }
        }
      }
    }
  }
}