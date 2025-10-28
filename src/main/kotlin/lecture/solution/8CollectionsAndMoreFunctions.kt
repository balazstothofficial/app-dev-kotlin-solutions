package lecture.solution

/**
 * # Collections
 * (Immutable) lists, sets and maps are a idiomatic way to store a variable number of
 *  items in a data structure.
 *
 * ## Tasks:
 * - Create an immutable list, an immutable set and an immutable map with example values.
 *   The list should contain [String]s.
 * - What are use-cases for these types of collections?
 *   When would be mutable collections the better option?
 *   When would be arrays the better option?
 * - We want to work on the list. Do the following tasks without using a loop:
 *      1. Filter out all elements, that have two or less characters.
 *      2. Append "end" to all remaining elements.
 *      3. Combine all strings to a single list of [Char]s.
 * - Define a generic function `lecture.printEach` that takes a list and prints all its values.
 * - Define a generic function `lecture.mapEverySecond` that operates on a list of type `List<A>`.
 *   The function takes two transformations of type `(A) -> B`:
 *      - The first function is applied to elements at even indices.
 *      - The second function is applied to elements at odd indices.
 *
 *      The result is a new list of type `List<B>` containing the transformed elements.
 * - Change `lecture.printEach` and `lecture.mapEverySecond` to be extension functions.
 * - The functions [let], [run], [apply], and [also] are idiomatic in Kotlin.
 *   What can they be used for?
 *   What is the difference between them?
 *
 * ## Resources:
 * - [Collections](https://kotlinlang.org/docs/collections-overview.html)
 * - [Collection transformations](https://kotlinlang.org/docs/collection-transformations.html)
 * - [Collection filtering](https://kotlinlang.org/docs/collection-filtering.html)
 * - [Generic functions](https://kotlinlang.org/docs/generics.html#generic-functions)
 * - [Extension functions](https://kotlinlang.org/docs/extensions.html)
 * - [Function varargs](https://kotlinlang.org/docs/functions.html#variable-number-of-arguments-varargs)
 * - [(Function types)](https://kotlinlang.org/docs/lambdas.html#function-types)
 * - [(Higher-order functions)](https://kotlinlang.org/docs/lambdas.html#higher-order-functions)
 * - [(Trailing lambdas)](https://kotlinlang.org/docs/lambdas.html#passing-trailing-lambdas)
 */
fun main() {
    // Immutable Collections (explain quickly also vararg)
    val list = listOf("a", "bb", "ccc")
    val set = setOf(1, 1, 2)
    val map = mapOf(1 to "a", 2 to "b")

    // Low-Level--usually not needed
    val array = arrayOf(1, 2, 3)

    val randomChars = list
        .filter { text -> text.length >= 2 }
        .map { it + "end" }
        .flatMap(String::toList)

    println(randomChars)

    // Generic Function
    printEach(list)

    mapEverySecond(listOf(1, 2, 3, 4), odd = { "$it is odd" }, even = { "$it is even" })

    // Extension Function
    printEach(
        mapEverySecond(
            listOf(1, 2, 3, 4),
            odd = { "$it is odd" },
            even = { "$it is even" })
    )
    // Better:
    listOf(1, 2, 3, 4)
        .mapEverySecondBetter(odd = { "$it is odd" }, even = { "$it is even" })
        .printEachBetter()

    val value = 3

    // Idiomatic Kotlin functions:
    value
        .also { println(it) }
        .apply { println(this) }
        .let { n -> n + 2 }
        .run { plus(2) }
}

fun <Element> printEach(list: List<Element>) {
    list.forEach(::println)
}

fun <E1, E2> mapEverySecond(list: List<E1>, even: (E1) -> E2, odd: (E1) -> E2): List<E2> = list
    .mapIndexed { index, element ->
        if (index % 2 == 0) even(element)
        else odd(element)
    }

fun <Element> List<Element>.printEachBetter() {
    forEach(::println)
}

fun <E1, E2> List<E1>.mapEverySecondBetter(even: (E1) -> E2, odd: (E1) -> E2): List<E2> =
    mapIndexed { index, element ->
        if (index % 2 == 0) even(element)
        else odd(element)
    }
