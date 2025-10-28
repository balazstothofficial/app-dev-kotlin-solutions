package lecture.solution

/**
 * # First Class Functions
 * Functions can be used as values and can stored in variables.
 * There are multiple ways to do so.
 *
 * ## Tasks:
 * - Store an anonymous function using the `fun` keyword in a immutable variable.
 *  It should take a [String] and return the [String] in lowercase.
 *  Read a [String] and store it in a variable `input`. Print it after applying this function.
 * - Store [String.uppercase] in a variable using a lambda. Use an explicit type annotation.
 * - Store [String.length] in a variable using a lambda. Use no explicit type annotation.
 * - Store [String.drop] in a variable using a function reference.
 * - Store `input.drop` in a variable using a bound function reference.
 * - Write a local named higher-order function,
 *   that takes a function of type `([String]) -> [String]` as parameter,
 *   applies the function to `input` and returns the result.
 * - Call each function and print the results.
 *
 * ## Resources:
 * - [Function types](https://kotlinlang.org/docs/lambdas.html#function-types)
 * - [Instantiating a function type](https://kotlinlang.org/docs/lambdas.html#instantiating-a-function-type)
 * - [Lambda expressions and anonymous functions](https://kotlinlang.org/docs/lambdas.html#lambda-expressions-and-anonymous-functions)
 * - [Function references](https://kotlinlang.org/docs/reflection.html#function-references)
 * - [Bound function references](https://kotlinlang.org/docs/reflection.html#bound-function-and-property-references)
 * - [Local functions](https://kotlinlang.org/docs/functions.html#local-functions)
 * - [Higher-order functions](https://kotlinlang.org/docs/lambdas.html#higher-order-functions)
 * - [(Trailing lambdas)](https://kotlinlang.org/docs/lambdas.html#passing-trailing-lambdas)
 */
fun main() {
    val lower = fun(text: String) = text.lowercase()
    val input = readln()
    println(lower(input))

    val upper: (String) -> String = { text -> text.uppercase() }
    val length = { text: String -> text.length }
    val drop: (String).(Int) -> String = String::drop
    val dropFromInput: (Int) -> String = input::drop

    fun local(transform: (String) -> String): String {
        return transform(input)
    }

    println(upper(input))
    println(length(input))
    println(drop(input, 2))
    println(dropFromInput(2))
    println(local { string -> string.removePrefix("ABC") })
}

