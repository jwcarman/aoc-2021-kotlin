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

class Day01 {
    @Test
    fun example1() {
        assertEquals(7, calculatePart1(readAsString("day01-example.txt")))
    }

    @Test
    fun part1() {
        assertEquals(1655, calculatePart1(readAsString("day01.txt")))
    }

    @Test
    fun example2() {
        assertEquals(5, calculatePart2(readAsString("day01-example.txt")))
    }

    @Test
    fun part2() {
        assertEquals(1683, calculatePart2(readAsString("day01.txt")))
    }

    private fun calculatePart1(input:String): Int {
        return input.lines()
            .map { it.toInt() }
            .windowed(2)
            .count { it[0] < it[1] }
    }

    private fun calculatePart2(input: String): Int {
        return input.lines()
            .map { it.toInt() }
            .windowed(3)
            .map { it.sum() }
            .windowed(2)
            .count { it[0] < it[1] }
    }
}