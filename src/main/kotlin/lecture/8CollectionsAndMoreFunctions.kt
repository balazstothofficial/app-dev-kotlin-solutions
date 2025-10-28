package lecture

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

}
