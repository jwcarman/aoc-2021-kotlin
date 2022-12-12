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