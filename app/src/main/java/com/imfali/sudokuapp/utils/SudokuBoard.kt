package com.imfali.sudokuapp.utils

import com.imfali.sudokuapp.data.SudokuData
import kotlin.random.Random

fun generateSudoku(removeNum: Int): SudokuData {
  val size = 9
  val initialBoard: MutableList<MutableList<Pair<Number, Boolean>>> =
    MutableList(size) { MutableList(size) { Pair(0, false) } }
  generateDiagonal(initialBoard, 0)
  solveSudoku(initialBoard, 0, 0)
  return SudokuData(
    board = initialBoard,
    answerBoard = initialBoard.map { innerList -> innerList.map { it.first } },
    remainingNumber = removeNumbers(initialBoard, removeNum),
    isInitialized = true
  )
}

fun generateDiagonal(board: MutableList<MutableList<Pair<Number, Boolean>>>, index: Int): Boolean {
  if(index == 9)
    return true
  val valid = false
  while (!valid){
    val num = Random.nextInt(1,10)
    if(isValid(board, index, index, num)){
      board[index][index] = Pair(num, false)
      if(generateDiagonal(board, index + 1))
        return true
      board[index][index] = Pair(0, false)
    }
  }
  return false
}

private fun solveSudoku(
  board: MutableList<MutableList<Pair<Number, Boolean>>>,
  row: Int,
  col: Int
): Boolean {
  if (row == 9)
    return true
  if (col == 9)
    return solveSudoku(board, row + 1, 0)
  for (num in 1 until 10) {
    if (isValid(board, row, col, num)) {
      board[row][col] = Pair(num, false)
      if (solveSudoku(board, row, col + 1))
        return true
    }
    board[row][col] = Pair(0, false)
  }
  return false
}

private fun isValid(
  board: MutableList<MutableList<Pair<Number, Boolean>>>,
  row: Int,
  col: Int,
  num: Int
): Boolean {
  for (i in 0 until 9) {
    if (board[row][i].first == num || board[i][col].first == num)
      return false
  }
  val startRow = (row / 3) * 3
  val startCol = (col / 3) * 3
  for (i in 0 until 3)
    for (j in 0 until 3)
      if (board[startRow + i][startCol + j].first == num)
        return false
  return true
}

fun removeNumbers(
  board: MutableList<MutableList<Pair<Number, Boolean>>>,
  count: Int
): MutableList<Number> {
  val remainingNumber: MutableList<Number> = MutableList(10) { 0 }
  var remaining = count
  while (remaining > 0) {
    val row = Random.nextInt(0, 9)
    val col = Random.nextInt(0, 9)
    val num = board[row][col].first
    if (num != 0) {
      remainingNumber[num as Int] = remainingNumber[num].toInt() + 1
      board[row][col] = Pair(0, true)
      remaining -= 1
    }
  }
  return remainingNumber
}