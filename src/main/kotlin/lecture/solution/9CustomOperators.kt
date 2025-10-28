package lecture.solution

/**
 * # Operators
 * Many operators can be overloaded in Kotlin using extension functions.
 *
 * ## Tasks:
 * - What does the plus-operator on lists do?
 * - Write a times-operator for lists.
 *
 * ## Resources:
 * - [Operator overloading](https://kotlinlang.org/docs/operator-overloading.html)
 * - [(Infix functions)](https://kotlinlang.org/docs/functions.html#infix-notation)
 */
fun main() {
    // Overloaded:
    println(listOf(1, 2, 3) + listOf(4, 5, 6))

    // Custom operator:
    println(listOf(1, 2, 3) * 4u)
}

operator fun <E> List<E>.times(scalar: UInt): List<E> {
    val result = mutableListOf<E>()

    repeat(scalar.toInt()) {
        result += this
    }
    return result
}

// Recursive version (inefficient):
/*
operator fun <E> List<E>.times(scalar: UInt): List<E> = when (scalar) {
    0u -> listOf()
    else -> this + this.times(scalar - 1u)
}
*/
