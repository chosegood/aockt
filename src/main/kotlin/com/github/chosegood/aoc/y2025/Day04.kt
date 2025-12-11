package com.github.chosegood.aoc.y2025

import com.github.chosegood.aoc.AdventOfCode
import com.github.chosegood.aoc.InputReader

fun main() {
    println("Part1: " + Day04().part1(InputReader.readInput("D0401_input.txt")))
    println("Part2: " + Day04().part2(InputReader.readInput("D0401_input.txt")))
}

class Day04 : AdventOfCode {

    private fun convertToInts(input: List<String>): Array<Array<Int>> {
        return input.map {
            it.map { if (it == '@') 1 else 0 }.toTypedArray()
        }.toTypedArray()
    }

    fun valueAt(arr: Array<Array<Int>>, x: Int, y: Int): Int {
        return if (x in 0..<arr[0].size && y in 0..<arr.size) {
            arr[x][y]
        } else {
            0
        }
    }

    fun neighboursOf(arr: Array<Array<Int>>, x: Int, y: Int): Long {
        if (x in 0..<arr[0].size && y in 0..<arr.size) {
            if (arr[x][y] == 0) {
                return 0
            }

            val sum = listOf(
                valueAt(arr, x - 1, y - 1),
                valueAt(arr, x - 1, y),
                valueAt(arr, x - 1, y + 1),
                valueAt(arr, x, y - 1),
                valueAt(arr, x, y + 1),
                valueAt(arr, x + 1, y - 1),
                valueAt(arr, x + 1, y),
                valueAt(arr, x + 1, y + 1),
            ).sum()

            return sum.toLong()
        } else {
            return 0L
        }
    }

    private fun convert(inputInts: Array<Array<Int>>): Pair<Long, Array<Array<Int>>> {
        val maxX = inputInts[0].size
        val maxY = inputInts.size

        var currSum = 0L
        val result = Array(maxX) { Array(maxY) { 0 } }

        (0..<maxX).forEach { x ->
            (0..<maxY).forEach { y ->
                if (valueAt(inputInts, x, y) == 1 && neighboursOf(inputInts, x, y) < 4) {
                    currSum += 1L
                    result[x][y] = 0
                } else {
                    currSum += 0
                    result[x][y] = inputInts[x][y]
                }
            }
        }

        return Pair(currSum, result)
    }

    override fun part1(input: List<String>): Long {
        val inputInts = convertToInts(input)
        return convert(inputInts).first
    }

    override fun part2(input: List<String>): Long {
        var inputInts = convertToInts(input)
        var currSum = 0L
        while (convert(inputInts).first > 0) {
            val convert = convert(inputInts)
            currSum += convert.first
            inputInts = convert(inputInts).second
        }
        return currSum
    }

}
