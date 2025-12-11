package com.github.chosegood.aoc.y2025

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test

class Day06Test {

    @Test
    fun part1() {
        val result = Day06().part1(
            listOf(
                "123 328  51 64 ",
                " 45 64  387 23 ",
                "  6 98  215 314",
                "*   +   *   +  ",
            )
        )
        assertThat(result, equalTo(4277556))
    }

    @Test
    fun part2() {
        val result = Day06().part2(
            listOf(
                "123 328  51 64 ",
                " 45 64  387 23 ",
                "  6 98  215 314",
                "*   +   *   +  ",
                )
        )
        assertThat(result, equalTo(3263827))
    }

}