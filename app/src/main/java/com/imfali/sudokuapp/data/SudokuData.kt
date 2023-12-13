package com.imfali.sudokuapp.data

data class SudokuData(
  var board: MutableList<MutableList<Pair<Number, Boolean>>>,
  var answerBoard: List<List<Number>>,
  var selected: Pair<Number, Number> = Pair(-1, -1),
  var remainingNumber: MutableList<Number> = List(10) { 0 }.toMutableList()
)
