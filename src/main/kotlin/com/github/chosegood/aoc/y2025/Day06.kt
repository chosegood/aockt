package com.github.chosegood.aoc.y2025

import com.github.chosegood.aoc.AdventOfCode
import com.github.chosegood.aoc.InputReader

fun main() {
    println("Part1: " + Day06().part1(InputReader.readInput("D0601_input.txt")))
    println("Part2: " + Day06().part2(InputReader.readInput("D0601_input.txt")))
}

class Day06 : AdventOfCode {


    override fun part1(input: List<String>): Long {
        val operators = input.last().split(" ").filter(String::isNotBlank)
        val values = input.dropLast(1)
            .map {
                it.split(" ")
                    .filter(String::isNotBlank)
                    .map(String::toLong)
            }

        return operators.mapIndexed { index, operator ->
            when (operator) {
                "*" -> values.map { it.getOrElse(index) { 0 } }.reduce { acc, value -> acc * value }
                "+" -> values.sumOf { it.getOrElse(index) { 0 } }
                else -> 0L
            }
        }.sum()
    }

    override fun part2(input: List<String>): Long {
        val maxCols = input.maxOfOrNull { it.length } ?: 0

        val columnAsNumbers = (0 until maxCols).map { col ->
            val trim = input.dropLast(1)
                .mapNotNull { row -> row.getOrNull(col) }
                .joinToString("")
                .trim()
            if (trim.isEmpty()) 0 else trim.toLong()
        }

        val operatorIndexes: List<Int> = input.last()
            .mapIndexedNotNull { index, ch -> if (ch == '+' || ch == '*') index else null }

        val columnGroups: List<List<Long>> = operatorIndexes.windowed(2, step = 1, partialWindows = true)
            .map { win ->
                if (win.size == 2) {
                    columnAsNumbers.subList(win.first(), win.last() - 1)
                } else {
                    columnAsNumbers.subList(win.first(), maxCols)
                }
            }

        return input.last()
            .filter { it.toString().isNotBlank() }
            .mapIndexed { index, operator ->
                when (operator) {
                    '*' -> columnGroups[index].reduce { acc, value -> acc * value }
                    '+' -> columnGroups[index].sumOf { it }
                    else -> 0L
                }
            }.sum()
    }

}
