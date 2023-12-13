package com.imfali.sudokuapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imfali.sudokuapp.data.SudokuViewModel
import com.imfali.sudokuapp.ui.theme.MyGray
import com.imfali.sudokuapp.ui.theme.Selected

@Composable
fun SudokuRow(viewModel: SudokuViewModel, rowIndex: Int) {
  LazyRow(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically
  ) {
    items(9) { colIndex ->
      SudokuCell(
        viewModel = viewModel,
        rowIndex = rowIndex,
        colIndex = colIndex,
      )
    }
  }
}

@Composable
fun SudokuCell(viewModel: SudokuViewModel, rowIndex: Int, colIndex: Int) {
  val board = viewModel.sudoku.value.board
  val answerBoard = viewModel.sudoku.value.answerBoard
  val selected = viewModel.sudoku.value.selected
  var isSelected by remember {
    mutableStateOf(false)
  }
  var isInRange by remember {
    mutableStateOf(false)
  }
  isSelected = selected.first == rowIndex && selected.second == colIndex
  isInRange = selected.first == rowIndex || selected.second == colIndex ||
      ((selected.first.toInt() >= (rowIndex / 3) * 3) && (selected.first.toInt() < ((rowIndex / 3) + 1) * 3)
          && (selected.second.toInt() >= (colIndex / 3) * 3) && (selected.second.toInt() < ((colIndex / 3) + 1) * 3))
  Box(
    modifier = Modifier
      .size(40.dp)
      .border(0.5.dp, Color.Gray)
      .background(if (isSelected) Selected else (if (isInRange) MyGray else Color.White))
      .clickable {
        viewModel.updateSelectedCell(Pair(rowIndex, colIndex))
      },
  ) {
    Text(
      text = (
          if (board[rowIndex][colIndex].first != 0)
            board[rowIndex][colIndex].first.toString()
          else
            ""
          ),
      color = (
          if (board[rowIndex][colIndex].first == answerBoard[rowIndex][colIndex])
            if (board[rowIndex][colIndex].second)
              Color.Blue
            else
              Color.Black
          else
            Color.Red
          ),
      modifier = Modifier.align(Alignment.Center),
      fontSize = 30.sp
    )
  }
}