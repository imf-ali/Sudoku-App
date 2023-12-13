package com.imfali.sudokuapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScoreDisplay(score: Int = 0){
  Box(
    modifier = Modifier.fillMaxWidth()
      .padding(16.dp),
    contentAlignment = Alignment.Center
  ) {
    Text(text = "Score: $score")
  }
}