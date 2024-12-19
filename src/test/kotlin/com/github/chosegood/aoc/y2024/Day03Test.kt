package com.github.chosegood.aoc.y2024

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class Day03Test {

    @Test
    fun part1() {
        val input: List<String> = listOf(
            "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))",
            )
        expectThat(Day03().part1(input))
            .isEqualTo(161)
    }

    @Test
    @Disabled
    fun part2() {
        val input: List<String> = listOf(
            "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))",
        )
        expectThat(Day03().part2(input))
            .isEqualTo(48)
    }
}