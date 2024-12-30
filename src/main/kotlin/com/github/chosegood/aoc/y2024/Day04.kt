package com.github.chosegood.aoc.y2024

import com.github.chosegood.aoc.AdventOfCode
import com.github.chosegood.aoc.InputReader

class Day04 : AdventOfCode {

    private fun String.isChristmas(): Boolean {
        return this.startsWith("XMAS")
    }

    private fun String.isMas(): Boolean {
        return this.startsWith("MAS") || this.startsWith("SAM")
    }

    override fun part1(input: List<String>): Long {
        var acc = 0L

        for (x in 0..<input[0].length) {
            for (y in input.indices) {
                if (verticalForward(input, x, y).isChristmas()) {
                    acc++
                }
                if (verticalBackwards(input, x, y).isChristmas()) {
                    acc++
                }
                if (horizontalDown(input, x, y).isChristmas()) {
                    acc++
                }
                if (horizontalUp(input, x, y).isChristmas()) {
                    acc++
                }
                if (diagDownRight(input, x, y).isChristmas()) {
                    acc++
                }
                if (diagDownLeft(input, x, y).isChristmas()) {
                    acc++
                }
                if (diagUpRight(input, x, y).isChristmas()) {
                    acc++
                }
                if (diagUpLeft(input, x, y).isChristmas()) {
                    acc++
                }
            }
        }

        return acc
    }

    private fun diagDownRight(input: List<String>, x: Int, y: Int): String {
        return (0..<4).map { charAt(input, x + it, y + it) }.joinToString(separator = "")
    }

    private fun diagDownLeft(input: List<String>, x: Int, y: Int): String {
        return (0..<4).map { charAt(input, x + it, y + it) }.joinToString(separator = "")
    }

    private fun diagUpRight(input: List<String>, x: Int, y: Int): String {
        return (0..<4).map { charAt(input, x + it, y - it) }.joinToString(separator = "")
    }

    private fun diagUpLeft(input: List<String>, x: Int, y: Int): String {
        return (0..<4).map { charAt(input, x - it, y - it) }.joinToString(separator = "")
    }

    private fun horizontalDown(input: List<String>, x: Int, y: Int): String {
        return (0..<4).map { charAt(input, x, y + it) }.joinToString(separator = "")
    }

    private fun horizontalUp(input: List<String>, x: Int, y: Int): String {
        return (0..<4).map { charAt(input, x, y - it) }.joinToString(separator = "")
    }

    private fun verticalForward(input: List<String>, x: Int, y: Int): String {
        return (0..<4).map { charAt(input, x + it, y) }.joinToString(separator = "")
    }

    private fun verticalBackwards(input: List<String>, x: Int, y: Int): String {
        return (0..<4).map { charAt(input, x - it, y) }.joinToString(separator = "")
    }

    private fun charAt(input: List<String>, x: Int, y: Int): Char? {
        return when {
            y < 0 -> null
            y > input.size - 1 -> null
            x < 0 -> null
            x > input[y].length - 1 -> null
            else -> input[y][x]
        }
    }

    override fun part2(input: List<String>): Long {
        var acc = 0L

        for (x in 0..<input[0].length) {
            for (y in input.indices) {
                val leftToRight = listOfNotNull(
                    charAt(input, x - 1, y - 1),
                    charAt(input, x, y),
                    charAt(input, x + 1, y + 1),
                ).joinToString(separator = "")

                val rightToLeft = listOfNotNull(
                    charAt(input, x - 1, y + 1),
                    charAt(input, x, y),
                    charAt(input, x + 1, y - 1),
                ).joinToString(separator = "")

                if (leftToRight.isMas() && rightToLeft.isMas()) {
                    println("$x,$y : leftToRight = $leftToRight rightToLeft = $rightToLeft")
                    acc++
                }
            }
        }

        return acc
    }
}

fun main() {
    println(Day04().part1(InputReader.readInput("D0401_input.txt")))
    println(Day04().part2(InputReader.readInput("D0402_input.txt")))
}
