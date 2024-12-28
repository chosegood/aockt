package com.github.chosegood.aoc.y2024

import com.github.chosegood.aoc.AdventOfCode
import com.github.chosegood.aoc.InputReader

class Day03 : AdventOfCode {

    override fun part1(input: List<String>): Long {
        val regex = """mul\((\d{1,3}),(\d{1,3})\)""".toRegex()
        return input
            .flatMap { regex.findAll(it).toList() }
            .sumOf { it.groupValues[1].toLong() * it.groupValues[2].toLong() }
    }

    override fun part2(input: List<String>): Long {
        val regex = """mul\((\d{1,3}),(\d{1,3})\)|do\(\)|don't\(\)""".toRegex()

        var acc = 0L
        var enabled = true
        input.forEach { line ->
            val matches: Sequence<MatchResult> = regex.findAll(line)
            for (match in matches) {
                if (match.value == "do()") {
                    enabled = true
                } else if (match.value == "don't()") {
                    enabled = false
                } else {
                    if (enabled) {
                        acc += match.groupValues[1].toLong() * match.groupValues[2].toLong()
                    }
                }
            }
        }

        return acc
    }
}

fun main() {
    println(Day03().part1(InputReader.readInput("D0301_input.txt")))
    println(Day03().part2(InputReader.readInput("D0302_input.txt")))
}
