package com.imfali.sudokuapp.data

data class SudokuData(
  var board: MutableList<MutableList<Pair<Number, Boolean>>> = MutableList(9) { MutableList(9) { Pair(0, false) } },
  var answerBoard: List<List<Number>> = List(9) { List(9) { 0 } },
  var selected: Pair<Number, Number> = Pair(-1, -1),
  var remainingNumber: MutableList<Number> = List(10) { 0 }.toMutableList(),
  var isInitialized: Boolean = false,
  var score: Number = 0,
  var mistake: Number = 0,
  var level: Level = Level.EASY
)
