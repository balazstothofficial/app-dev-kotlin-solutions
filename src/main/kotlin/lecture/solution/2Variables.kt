package lecture.solution

/**
 * # Variables
 * Variables can be mutable or immutable.
 *
 * ## Tasks:
 * - Find the difference!
 *
 * ## Resources:
 * - [Variables](https://kotlinlang.org/docs/basic-syntax.html#variables)
 **/
fun main() {
    // Immutable variable with type inference
    val immutable = 1
    // immutable = 2 // Does not compile

    // Mutable variable with type inference (just use if really necessary)
    var mutable = 1
    mutable = 2

    println(immutable)
    println(mutable)
}
