package com.imfali.sudokuapp.data

sealed class Level(val cellNumber: Number, val name: String) {
  object EASY: Level(30, "Easy")
  object MEDIUM: Level(40, "Medium")
  object HARD: Level(50, "Hard")
}