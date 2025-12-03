package com.github.chosegood.aoc.y2025

import com.github.chosegood.aoc.AdventOfCode
import com.github.chosegood.aoc.InputReader

fun main() {
    println("Part1: " + Day02().part1(InputReader.readInput("D0201_input.txt")))
    println("Part2: " + Day02().part2(InputReader.readInput("D0201_input.txt")))
}

class Day02 : AdventOfCode {

    override fun part1(input: List<String>): Long {
        fun isValid(value: String): Boolean {
            if (value.length % 2 != 0) {
                return true
            } else {
                val i = value.length / 2
                return value.take(i) != value.takeLast(i)
            }
        }

        return input[0]
            .split(",")
            .map {
                val separatorIndex = it.indexOf('-')
                LongRange(
                    it.take(separatorIndex).toLong(),
                    it.drop(separatorIndex + 1).toLong()
                )
            }
            .flatMap { range -> range.filterNot { num -> isValid(num.toString()) } }
            .sum()
    }

    override fun part2(input: List<String>): Long {
        fun isValid(value: String): Boolean {
            (1..value.length / 2).forEach {
                val repeat = value.take(it).repeat(value.length / it)
                if (repeat == value) {
                    return false
                }
            }
            return true
        }

        return input[0]
            .split(",")
            .map {
                val separatorIndex = it.indexOf('-')
                LongRange(
                    it.take(separatorIndex).toLong(),
                    it.drop(separatorIndex + 1).toLong()
                )
            }
            .flatMap { range -> range.filterNot { num -> isValid(num.toString()) } }
            .sum()
    }

}
