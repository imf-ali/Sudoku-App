package com.imfali.sudokuapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imfali.sudokuapp.data.SudokuViewModel
import com.imfali.sudokuapp.ui.theme.Blue34

@Composable
fun ScoreDisplay(viewModel: SudokuViewModel){
  val mistake = viewModel.sudoku.value.mistake
  val score = viewModel.sudoku.value.score
  val level = viewModel.sudoku.value.level
  Column {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp, bottom = 16.dp),
      contentAlignment = Alignment.Center
    ) {
      Text(
        color = Blue34,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        text = "Score: $score"
      )
    }
    Row(
      modifier = Modifier
        .width(333.dp)
        .padding(bottom = 5.dp)
        .align(alignment = Alignment.CenterHorizontally),
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      Text(text = "Mistakes: ${mistake}/3", fontSize = 13.sp)
    }
  }
}