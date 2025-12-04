package com.github.chosegood.aoc.y2025

import com.github.chosegood.aoc.AdventOfCode
import com.github.chosegood.aoc.InputReader

fun main() {
    println("Part1: " + Day03().part1(InputReader.readInput("D0301_input.txt")))
    println("Part2: " + Day03().part2(InputReader.readInput("D0301_input.txt")))
}

class Day03 : AdventOfCode {

    override fun part1(input: List<String>): Long {
        fun joltage(line: String): Long {
            val chars: CharArray = line.toCharArray()
            val mapIndexed = chars.mapIndexed { index, c -> Pair(index, c.toString().toLong()) }
            val maxBy1 = mapIndexed.dropLast(1).maxBy { it.second }
            val maxBy2 = mapIndexed.drop(maxBy1.first + 1).maxBy { it.second }
            return "${maxBy1.second}${maxBy2.second}".toLong()
        }

        return input.sumOf { joltage(it) }
    }


    override fun part2(input: List<String>): Long {
        fun largestWithin(mapIndexed: List<Pair<Int, Long>>, dropFirst: Int, dropLast: Int): Pair<Int, Long> {
            return mapIndexed.drop(dropFirst + 1).dropLast(dropLast).maxBy { it.second }
        }

        fun joltage(line: String): Long {
            val chars: CharArray = line.toCharArray()
            val mapIndexed = chars.mapIndexed { index, c -> Pair(index, c.toString().toLong()) }

            val mostSignificantNumber = mapIndexed.dropLast(11).maxBy { it.second }
            var currentIndex = mostSignificantNumber.first
            val map = (10 downTo 0).map { index ->
                val largestWithin = largestWithin(mapIndexed, currentIndex, index)
                currentIndex = largestWithin.first
                largestWithin
            }
            return (mostSignificantNumber.second.toString() + map.map { it.second }.joinToString("")).toLong()
        }

        return input.sumOf { joltage(it) }
    }

}
