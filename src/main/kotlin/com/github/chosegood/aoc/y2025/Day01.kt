package com.github.chosegood.aoc.y2025

import com.github.chosegood.aoc.AdventOfCode
import com.github.chosegood.aoc.InputReader

fun main() {
    println("Part1: " + Day01().part1(InputReader.readInput("D0101_input.txt")))
    println("Part2: " + Day01().part2(InputReader.readInput("D0101_input.txt")))
}

class Day01 : AdventOfCode {

    override fun part1(input: List<String>): Long {
        var dial: Long = 50
        var password = 0L
        input.forEach {
            val amount = if (it[0].toString() == "L") {
                -it.drop(1).toLong()
            } else {
                it.drop(1).toLong()
            }
            dial += amount % 100
            while (dial < 0) {
                dial += 100
            }
            while (dial >= 100) {
                dial -= 100
            }
            if (dial == 0L) password += 1
        }
        return password
    }

    override fun part2(input: List<String>): Long {
        var dial = 50
        var rotations = 0L

        input.forEach {
            val direction = if (it[0].toString() == "L") -1 else 1
            repeat(it.drop(1).toInt()) {
                dial = (dial + direction) % 100
                if (dial == 0) rotations++
            }
        }
        return rotations
    }
}
