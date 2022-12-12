/*
 * Copyright (c) 2022 James Carman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package aoc

import adventofcode.util.readAsString
import junit.framework.TestCase.assertEquals
import org.junit.Test

class Day03 {
    @Test
    fun example1() {
        assertEquals(198, calculatePart1(readAsString("day03-example.txt")))
    }

    @Test
    fun part1() {
        assertEquals(2035764, calculatePart1(readAsString("day03.txt")))
    }

    @Test
    fun example2() {
        assertEquals(230, calculatePart2(readAsString("day03-example.txt")))
    }

    @Test
    fun part2() {
        assertEquals(2817661, calculatePart2(readAsString("day03.txt")))
    }


    private fun calculatePart1(input: String): Int {
        val lines = input.lines()
        val bitCount = lines[0].length

        val binary = (0 until bitCount).map { mostCommonBitAt(lines, it) }.joinToString(separator = "")
        val gamma = binary.toInt(2)
        val epsilon = binary.flipBits().toInt(2)

        return gamma * epsilon
    }

    private fun calculatePart2(input: String): Int {
        return oxygenGeneratorRating(input) * c02ScrubberRating(input)
    }

    private fun calculateRating(input: String, bitFilterOf: (List<String>, Int) -> Char): Int {
        var lines = input.lines()
        var bit = 0
        while (lines.size > 1) {
            val bitFilter = bitFilterOf(lines, bit)
            lines = lines.filter { it[bit] == bitFilter }
            bit++
        }
        return lines[0].toInt(2)
    }

    private fun oxygenGeneratorRating(input: String): Int {
        return calculateRating(input, ::mostCommonBitAt)
    }

    private fun c02ScrubberRating(input: String): Int {
        return calculateRating(input, ::leastCommonBitAt)
    }

    private fun mostCommonBitAt(lines: List<String>, ndx: Int): Char {
        val sum = lines.sumOf { valueOfBitAt(it, ndx) }
        return if (sum >= 0) '1' else '0'
    }

    private fun leastCommonBitAt(lines: List<String>, ndx: Int): Char {
        val sum = lines.sumOf { valueOfBitAt(it, ndx) }
        return if (sum >= 0) '0' else '1'
    }

    private fun valueOfBitAt(line: String, ndx: Int): Int {
        return if (line[ndx] == '1') 1 else -1
    }

    private fun String.flipBits(): String {
        return map { c ->
            if (c == '0') {
                '1'
            } else {
                '0'
            }
        }.joinToString(separator = "")
    }


}