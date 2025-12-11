package com.github.chosegood.aoc.y2025

import com.github.chosegood.aoc.AdventOfCode
import com.github.chosegood.aoc.InputReader

fun main() {
    println("Part1: " + Day05().part1(InputReader.readInput("D0501_input.txt")))
    println("Part2: " + Day05().part2(InputReader.readInput("D0501_input.txt")))
}

class Day05 : AdventOfCode {

    override fun part1(input: List<String>): Long {

        val freshIngredientRanges: List<LongRange> = input.takeWhile { it.isNotBlank() }
            .map {
                val separatorIndex = it.indexOf('-')
                LongRange(
                    it.take(separatorIndex).toLong(),
                    it.drop(separatorIndex + 1).toLong()
                )
            }

        val ingredients: List<Long> = input.subList(input.indexOfFirst { it.isEmpty() } + 1, input.size)
            .map { it.toLong() }

        return ingredients.count { freshIngredientRanges.any { range -> range.contains(it) } }.toLong()
    }

    override fun part2(input: List<String>): Long {

        val freshIngredientRanges = input.takeWhile { it.isNotBlank() }
            .map {
                val separatorIndex = it.indexOf('-')
                LongRange(
                    it.take(separatorIndex).toLong(),
                    it.drop(separatorIndex + 1).toLong()
                )
            }
            .sortedBy { it.first }
            .fold(mutableListOf<LongRange>()) { acc, range ->
                val last = acc.lastOrNull()
                if (last != null && range.first <= last.last + 1) {
                    acc[acc.lastIndex] = last.first..maxOf(last.last, range.last)
                } else {
                    acc.add(range)
                }
                acc
            }

        return freshIngredientRanges.sumOf { range -> range.last - range.first + 1 }

    }

}
