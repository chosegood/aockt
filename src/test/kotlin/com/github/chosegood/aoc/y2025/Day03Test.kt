package com.github.chosegood.aoc.y2025

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test

class Day03Test {

    @Test
    fun part1() {
        val result = Day03().part1(
            listOf(
                "987654321111111",
                "811111111111119",
                "234234234234278",
                "818181911112111",
            )
        )
        assertThat(result, equalTo(357))
    }

    @Test
    fun part2() {
        val result = Day03().part2(
            listOf(
                "987654321111111",
                "811111111111119",
                "234234234234278",
                "818181911112111",
            )
        )
        assertThat(result, equalTo(3121910778619))
    }

}