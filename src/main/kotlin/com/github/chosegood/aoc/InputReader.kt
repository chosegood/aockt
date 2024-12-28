package com.github.chosegood.aoc

import java.io.FileNotFoundException


class InputReader {
    companion object {
        fun readInput(fileName: String): List<String> {
            val resource = InputReader::class.java.classLoader.getResource(fileName)
                ?: throw FileNotFoundException("$fileName not found")
            return resource.readText().trim().lines()
        }
    }
}