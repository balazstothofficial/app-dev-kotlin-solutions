package lecture.solution

/**
 * # Nullables
 *
 * Kotlin has null safety.
 *
 * Tasks:
 * - Read a [String]
 * - Try to convert it safely to an [Int]
 * - If it was an [Int] double it and print it, otherwise print 0
 *
 * Resources:
 * - [Null safety](https://kotlinlang.org/docs/null-safety.html)
 **/
fun main() {
    val input = readln()

    val number = input.toIntOrNull()?.times(2) ?: 0

    println(number)
}
