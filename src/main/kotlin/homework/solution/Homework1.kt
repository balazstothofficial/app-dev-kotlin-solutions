package homework.solution

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
 */
fun main() {
    while (true) {
        println("What do you want to do?")
        println("1) uppercase   2) lowercase  3) drop N  4) trim  0) quit")

        val choice = readChoice()
        if (choice == 0) return

        val transformation = transformation(choice, ::readAmount)

        println("Enter text:")
        val input = readln()

        val result = transformation(input)

        println("Result:")
        println(result)

        println()
        println(analytics(result))
        println()
    }
}

/**
 * [amount] is a parameter, because we want to separate logic/ pure code from side-effects like
 * reading or printing.
 */
private fun transformation(choice: Int, amount: () -> Int): (String) -> String =
    when (choice) {
        1 -> String::uppercase
        2 -> String::lowercase
        3 -> { string -> string.drop(amount()) }
        4 -> String::trim
        else -> { string -> string }
    }

private fun analytics(text: String): String {
    val parity = if (text.length % 2 == 0) "even" else "odd"
    val containsKotlin = text.lowercase().contains("kotlin")

    return "Length: ${text.length}. Parity: $parity. Contains Kotlin: $containsKotlin."
}

private fun readChoice() =
    readInt(invalidPrompt = "Invalid Choice! Try again!", range = 0..4)

private fun readAmount(): Int {
    println("How many?")
    return readInt("Invalid number! Try again!", 0..Int.MAX_VALUE)
}

private fun readInt(
    invalidPrompt: String,
    range: IntRange = Int.MIN_VALUE..Int.MAX_VALUE
): Int {
    var value: Int? = readln().toIntOrNull()
    while (value == null || value !in range) {
        println(invalidPrompt)
        value = readln().toIntOrNull()
    }
    return value
}
