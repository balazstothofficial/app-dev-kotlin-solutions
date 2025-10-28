package lecture.solution

/**
 * # Basic Types
 * Strings, characters, booleans, and (signed or unsigned) numbers are basic types in Kotlin.
 *
 * ## Tasks:
 * - Create one variable of each type.
 *
 * ## Resources:
 * - [Strings](https://kotlinlang.org/docs/strings.html)
 * - [Characters](https://kotlinlang.org/docs/characters.html)
 * - [Boolean](https://kotlinlang.org/docs/booleans.html)
 * - [Numbers](https://kotlinlang.org/docs/numbers.html)
 * - [Unsigned numbers](https://kotlinlang.org/docs/unsigned-integer-types.html)
 **/
fun main() {

    // String
    val string /*: String*/ = "Hello"

    // Char
    val char /*: Char*/ = 'C'

    println(string + char)

    // Boolean
    val boolean: Boolean = true

    // Numbers (with explicit type annotation)

    // 32-bit
    val int: Int = 2
    // 64-bit
    val long: Long = 2
    // 16-bit
    val short: Short = 2
    // 8-bit
    val byte: Byte = 2

    val float: Float = 2f
    val double: Double = 2.0

    // Unsigned numbers
    val uShort: UShort = 2u
    val uByte: UByte = 2u
    val uInt: UInt = 2u
    val uLong: ULong = 2u
}
