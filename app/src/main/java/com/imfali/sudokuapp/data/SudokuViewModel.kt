package com.imfali.sudokuapp.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.imfali.sudokuapp.utils.generateSudoku

class SudokuViewModel : ViewModel() {
  private val _sudoku: MutableState<SudokuData> = mutableStateOf(SudokuData())
  val sudoku: State<SudokuData> = _sudoku

  fun dismissBoard(){
    _sudoku.value = SudokuData()
  }

  fun generateSudokuBoard(level: Level){
    _sudoku.value = generateSudoku(level)
  }

  private fun increaseScore(num: Number = 10){
    _sudoku.value.score = _sudoku.value.score.toInt() + num.toInt()
  }

  private fun decreaseScore(num: Number = 5){
    _sudoku.value.score = _sudoku.value.score.toInt() - num.toInt()
  }

  private fun increaseMistake(){
    _sudoku.value.mistake = _sudoku.value.mistake.toInt() + 1
  }

  fun updateSelectedCell(cell: Pair<Number, Number>) {
    _sudoku.value = SudokuData(
      _sudoku.value.board,
      _sudoku.value.answerBoard,
      cell,
      _sudoku.value.remainingNumber,
      _sudoku.value.isInitialized,
      _sudoku.value.score,
      _sudoku.value.mistake,
      _sudoku.value.level
    )
  }

  fun updateBoardAndRemainingList(index: Number) {
    val row = _sudoku.value.selected.first.toInt()
    val col = _sudoku.value.selected.second.toInt()
    val board = _sudoku.value.board
    val remainingNumber = _sudoku.value.remainingNumber
    val answer = _sudoku.value.answerBoard
    val mistake = _sudoku.value.mistake
    val cellsToFill = _sudoku.value.level.cellNumber
    if (row == -1 || col == -1 || board[row][col].first == answer[row][col] || remainingNumber[index.toInt()] == 0) {
      return
    }
    if(index == answer[row][col]){
      increaseScore()
      if (_sudoku.value.score == cellsToFill.toInt() * 10 - mistake.toInt() * 5)
        increaseScore(100)
    } else {
      increaseMistake()
      decreaseScore()
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
          else if ((ind == previousSelected) && (ind != index))
            num.toInt() + 1
          else
            num
        }
        .toMutableList(),
      isInitialized = _sudoku.value.isInitialized,
      score = _sudoku.value.score,
      mistake = _sudoku.value.mistake,
      level = _sudoku.value.level
    )
  }
}