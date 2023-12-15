package com.imfali.sudokuapp.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imfali.sudokuapp.data.SudokuViewModel
import com.imfali.sudokuapp.ui.theme.Blue34

@Composable
fun RemainingNumbers(viewModel: SudokuViewModel){
  val board = viewModel.sudoku.value.board
  val remainingNumber = viewModel.sudoku.value.remainingNumber
  val selected = viewModel.sudoku.value.selected
  LazyRow(
    modifier = Modifier
      .fillMaxWidth()
      .padding(top = 50.dp),
    horizontalArrangement = Arrangement.SpaceEvenly
  ) {
    itemsIndexed(remainingNumber) { index, number ->
      if (index != 0) {
        Box(
          modifier = Modifier
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .padding(top = 4.dp, bottom = 4.dp)
            .width(35.dp),
        ) {
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .clickable{
                viewModel.updateBoardAndRemainingList(index)
              },
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text(text = (index).toString(), fontSize = 27.sp, color = Blue34)
            Text(text = (number).toString(), fontSize = 13.sp)
          }
        }
      }
    }
  }
}