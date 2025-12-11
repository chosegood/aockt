package com.github.chosegood.aoc.y2025

import com.github.chosegood.aoc.AdventOfCode
import com.github.chosegood.aoc.InputReader

fun main() {
    println("Part1: " + Day06().part1(InputReader.readInput("D0601_input.txt")))
    println("Part2: " + Day06().part2(InputReader.readInput("D0601_input.txt")))
}

class Day06 : AdventOfCode {


    override fun part1(input: List<String>): Long {
        val rows = input
            .map { it.split(" ")
            .filter(String::isNotBlank) }
        val operators = rows.last()
        val values = rows.dropLast(1).map { it: List<String> -> it.map { it.toLong() } }
        return operators.mapIndexed { index, operator ->
            when (operator) {
                "*" -> values.map { it.getOrElse(index) { 0 } }.reduce { acc, value -> acc * value }
                "+" -> values.sumOf { it.getOrElse(index) { 0 } }
                else -> 0L
            }
        }.sum()
    }

    override fun part2(input: List<String>): Long {
        return 0L
    }

}
