package homework.solution

import homework.solution.Transformation.Drop
import homework.solution.Transformation.Lowercase
import homework.solution.Transformation.Trim
import homework.solution.Transformation.Uppercase

/**
 * # Homework 1: Tiny Text Utility
 *
 * Build a small text utility program.
 *
 * ## Tasks:
 * 1. Ask the user which of these 5 options they want to choose:
 *    uppercase, lowercase, drop, trim, quit
 *    If the user selects "quit", end the program.
 * 2. Otherwise, read a string from the user and apply the action they chose.
 *    For the option "drop" you need to read an additional value.
 * 3. Print the result.
 * 4. Start again at step 1.
 *
 * For the actions these functions should be used: [String.uppercase], [String.lowercase],
 *  [String.drop], and [String.trim]
 *
 * ## Requirements:
 * - Do not crash on invalid inputs.
 * - Decompose your solution into at least 3 functions.
 * - Use at least one when-expression.
 * - Use at least one default-parameter
 * - Store at least once a function in a variable.
 * - Use at least one function reference.
 *
 * ## Bonus:
 * - Print statistics after the transformation:
 *      - Length of input string.
 *      - Parity of input string.
 *      - Does it contain the word "Kotlin"?
 * - Implement more transformations.
 *
 */
fun main() {
    while (true) {
        printChoices()

        val transformation = when (val choice = readChoice()) {
            Quit -> return
            is Transformation -> transformation(choice, ::readAmount)
        }

        println("Enter text:")
        val input = readln()

        val result = transformation(input)

        println("Result:")
        println(result)

        println("Analytics:")
        println(Analytics(result))
        println()
    }
}

private sealed interface Choice {
    val value: Int
    val name: String

    val choice: String
        get() = "$value) $name"
}

private object Quit : Choice {
    override val value: Int = 0
    override val name: String = "Quit"

    override fun toString(): String = choice
}

/**
 * In this small use-case we can easily also just work with [Int]s directly.
 * But for bigger programs, enums (or sealed interfaces) can be very useful.
 * It makes when-expressions exhaustive and makes additions or deletions of cases less error-prone.
 * Try to add the case "Take" and see how the compiler guides you.
 *
 * A name parameter could be added to not rely on the names of the enum-cases.
 */
private enum class Transformation(override val value: Int) : Choice {
    Uppercase(1), Lowercase(2), Drop(3), Trim(4)/*, Take(5)*/;

    override fun toString(): String = choice

    companion object {
        private val map = entries.associateBy(Transformation::value)

        fun fromValue(type: Int) = map[type]
    }
}

/**
 * [amount] is a parameter, because we want to separate logic/ pure code from side-effects like
 * reading or printing.
 */
private fun transformation(transformation: Transformation, amount: () -> Int): (String) -> String =
    when (transformation) {
        Uppercase -> String::uppercase
        Lowercase -> String::lowercase
        Drop -> { string -> string.drop(amount()) }
        Trim -> String::trim
    }

/**
 * For real use cases it is better create a data type like this for the analytics data and
 * not directly convert it to a string. This code is more reusable.
 */
private data class Analytics(val text: String) {
    enum class Parity { Even, Odd }

    val length by lazy { text.length }
    val parity by lazy { if (length % 2 == 0) Parity.Even else Parity.Odd }
    val containsKotlin by lazy { text.contains("kotlin", ignoreCase = true) }

    override fun toString() =
        "Length: ${text.length}. Parity: ${parity.name}. Contains Kotlin: $containsKotlin."
}

private fun printChoices() {
    println("What do you want to do?")

    Transformation.entries
        .sortedBy { it.value }
        .forEach { print("$it \t") }

    println(Quit)
}

private fun readChoice(): Choice {
    val choice = readInt(
        invalidPrompt = "Invalid Choice! Try again!",
        range = 0..Transformation.entries.size
    )

    return Transformation.fromValue(choice) ?: Quit
}

private fun readAmount(range: IntRange = 0..Int.MAX_VALUE): Int {
    println("How many?")
    return readInt("Invalid number! Try again!", range)
}

/**
 * Implemented as tail recursive function.
 *
 * [Tail-Recursion](https://kotlinlang.org/docs/functions.html#tail-recursive-functions)
 * */
private tailrec fun readInt(
    invalidPrompt: String,
    range: IntRange = Int.MIN_VALUE..Int.MAX_VALUE
): Int {
    val value = readln().toIntOrNull()
    if (value == null || value !in range) {
        println(invalidPrompt)
        return readInt(invalidPrompt, range)
    }
    return value
}
