package com.github.chosegood.aoc.y2025

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test

class Day01Test {

    @Test
    fun part1() {
        val part1 = Day01().part1(
            listOf(
                "L68",
                "L30",
                "R48",
                "L5",
                "R60",
                "L55",
                "L1",
                "L99",
                "R14",
                "L82",
            )
        )
        assertThat(part1, equalTo(3))
    }

    @Test
    fun part2() {
        val part2 = Day01().part2(
            listOf(
                "L68",
                "L30",
                "R48",
                "L5",
                "R60",
                "L55",
                "L1",
                "L99",
                "R14",
                "L82",
            )
        )
        assertThat(part2, equalTo(6))
    }
    @Test
    fun part2_R1000() {
        val part2 = Day01().part2(
            listOf(
                "R1000",
            )
        )
        assertThat(part2, equalTo(10))
    }

}