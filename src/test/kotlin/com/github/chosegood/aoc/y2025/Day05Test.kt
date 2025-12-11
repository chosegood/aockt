package com.github.chosegood.aoc.y2025

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test

class Day05Test {

    @Test
    fun part1() {
        val result = Day05().part1(
            listOf(
                "3-5",
                "10-14",
                "16-20",
                "12-18",
                "",
                "1",
                "5",
                "8",
                "11",
                "17",
                "32",
            )
        )
        assertThat(result, equalTo(3))
    }

    @Test
    fun part2() {
        val result = Day05().part2(
            listOf(
                "3-5",
                "10-14",
                "16-20",
                "12-18",
                "",
                "1",
                "5",
                "8",
                "11",
                "17",
                "32",
            )
        )
        assertThat(result, equalTo(14))
    }

}