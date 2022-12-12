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

class Day02 {
    @Test
    fun example1() {
        assertEquals(150, calculatePart1(readAsString("day02-example.txt")))
    }

    @Test
    fun part1() {
        assertEquals(2272262, calculatePart1(readAsString("day02.txt")))
    }

    @Test
    fun example2() {
        assertEquals(900, calculatePart2(readAsString("day02-example.txt")))
    }

    @Test
    fun part2() {
        assertEquals(2134882034, calculatePart2(readAsString("day02.txt")))
    }

    private fun calculatePart1(input: String): Int {
        val position = input.lines()
            .fold(Pair(0, 0)) { position, line ->
                val direction = line.substringBefore(' ')
                val amount = line.substringAfter(' ').toInt()
                when (direction) {
                    "up" -> Pair(position.first, position.second - amount)
                    "down" -> Pair(position.first, position.second + amount)
                    else -> Pair(position.first + amount, position.second)
                }
            }
        return position.first * position.second
    }

    private fun calculatePart2(input: String): Int {
        val position = input.lines()
            .fold(Triple(0, 0, 0)) { position, line ->
                val direction = line.substringBefore(' ')
                val amount = line.substringAfter(' ').toInt()
                when (direction) {
                    "up" -> Triple(position.first, position.second, position.third - amount)
                    "down" -> Triple(position.first, position.second, position.third + amount)
                    else -> Triple(position.first + amount, position.second + (amount * position.third), position.third)
                }
            }
        return position.first * position.second
    }
}