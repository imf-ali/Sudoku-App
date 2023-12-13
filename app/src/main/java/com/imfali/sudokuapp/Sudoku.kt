package com.imfali.sudokuapp.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.imfali.sudokuapp.components.RemainingNumbers
import com.imfali.sudokuapp.components.ScoreDisplay
import com.imfali.sudokuapp.components.SudokuRow
import com.imfali.sudokuapp.data.SudokuViewModel

@SuppressLint("MutableCollectionMutableState")
@Composable
fun Sudoku(viewModel: SudokuViewModel) {
  Column(
    modifier = Modifier.padding(vertical = 20.dp)
  ) {
    ScoreDisplay()
    Box(
      modifier = Modifier
        .border(2.dp, Color.Black)
        .width(360.dp)
        .align(Alignment.CenterHorizontally)
    ) {
      LazyColumn {
        items(9) { rowIndex ->
          SudokuRow(viewModel, rowIndex)
        }
      }
    }
    RemainingNumbers(viewModel)
  }
}