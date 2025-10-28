package lecture.solution

/**
 * # Control Flow
 *
 * ## Tasks:
 * - Read a [String]. If it has an even length print "Even", else print "Odd".
 * - Read an [Int] safely. If the input is not an [Int] print "Not a number",
 *   if it is 1 or 2 print "Small", if it is 3 or 4 print "Medium", else print "Big".
 * - Read a [String]. Print each character of string on a separate line using a for-loop.
 * - Read [String]s until "Kotlin" is entered. If it was wrong, print "Try again".
 *
 * ## Resources:
 * - [If](https://kotlinlang.org/docs/control-flow.html#if-expression)
 * - [When](https://kotlinlang.org/docs/control-flow.html#when-expressions-and-statements)
 * - [For](https://kotlinlang.org/docs/control-flow.html#for-loops)
 * - [While](https://kotlinlang.org/docs/control-flow.html#while-loops)
 * - [(Ranges)](https://kotlinlang.org/docs/ranges.html)
 **/
fun main() {
    val input = readln()

    // 3 Versions:
    // 1. Version: With curly brackets
    if (input.length % 2 == 0) {
        println("Even")
    } else {
        println("Odd")
    }
    /*
    2. Version: Without curly brackets. Works because the branches consist of a single line
    if (input.length % 2 == 0) println("Even") else println("Odd")
    */

    /*
    3. Version: if's are expressions
    val string = if (input.length % 2 == 0) "Even" else "Odd"

    println(string)
    */

    val number = readln().toIntOrNull()

    // "when" is a nice way to pattern match over a value.
    // As a statement it does not need to be exhaustive.
    when (number) {
        null -> println("Not a number")
        1, 2 -> println("Small")
        3, 4 -> println("Medium")
        else -> println("Big")
    }

    /*
    "when" as an expression. Needs to be exhaustive!

    val size = when (number) {
        null -> "Not a number"
        1, 2 -> "Small"
        3, 4 -> "Medium"
        else -> "Big"
    }
    println(size)

    Does not compile!
    val size = when (number) {
        1, 2 -> "Small"
    }

    We will see when-expressions in more advanced settings later.
    */

    val string = readln()

    // Loops (Just use if really needed)

    // for-Loop
    for (c in string.toCharArray()) {
        println(c)
    }

    /*
    Quickly show ranges as well.
    for (i in 2..30) {
        println(i)
    }
    */

    while (readln() != "Kotlin") {
        println("Try again")
    }
}
