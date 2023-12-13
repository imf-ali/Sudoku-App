package com.imfali.sudokuapp.data

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.imfali.sudokuapp.utils.generateSudoku

class SudokuViewModel : ViewModel() {
  private val _sudoku = mutableStateOf(generateSudoku())
  val sudoku: State<SudokuData> = _sudoku

  fun updateSelectedCell(cell: Pair<Number, Number>) {
    _sudoku.value = SudokuData(
      _sudoku.value.board,
      _sudoku.value.answerBoard,
      cell,
      _sudoku.value.remainingNumber
    )
  }

  fun updateBoardAndRemainingList(index: Number) {
    val row = _sudoku.value.selected.first.toInt()
    val col = _sudoku.value.selected.second.toInt()
    val board = _sudoku.value.board
    val remainingNumber = _sudoku.value.remainingNumber
    val answer = _sudoku.value.answerBoard
    if (row == -1 || col == -1 || board[row][col].first == answer[row][col] || remainingNumber[index.toInt()] == 0) {
      return
    }
    val previousSelected = _sudoku.value.board[row][col].first
    _sudoku.value.board[row][col] = Pair(index, true)
    _sudoku.value = SudokuData(
      board = _sudoku.value.board,
      answerBoard = _sudoku.value.answerBoard,
      remainingNumber = _sudoku.value.remainingNumber
        .mapIndexed { ind, num ->
          if ((ind == index) && (ind != previousSelected) && num.toInt() > 0)
            num.toInt() - 1
          else if((ind == previousSelected) && (ind != index))
            num.toInt() + 1
          else
            num
        }
        .toMutableList()
    )
  }
}