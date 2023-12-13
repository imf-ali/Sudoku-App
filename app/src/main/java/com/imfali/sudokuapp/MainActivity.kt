package com.imfali.sudokuapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.imfali.sudokuapp.data.SudokuViewModel
import com.imfali.sudokuapp.screen.Sudoku
import com.imfali.sudokuapp.ui.theme.SudokuAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      SudokuAppTheme {
        val viewModel: SudokuViewModel = viewModel()
        SudokuAppTheme {
          Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Sudoku(viewModel)
          }
        }
      }
    }
  }
}