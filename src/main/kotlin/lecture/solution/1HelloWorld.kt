package lecture.solution

/**
 * # Hello World
 *
 * `main` functions are the program entry points.
 * You can have one per file.
 * In IntelliJ you can start a program by clicking on the green arrow next to a main function.
 *
 * ## Tasks:
 * - Create a `main` function.
 * - Print "Hello World!".
 * - Ask for the users name.
 * - Greet the user with his name.
 *
 * ## Resources:
 * - [Main function](https://kotlinlang.org/docs/basic-syntax.html#program-entry-point)
 * - [Print and read](https://kotlinlang.org/docs/basic-syntax.html#print-to-the-standard-output)
 * - [Comments](https://kotlinlang.org/docs/basic-syntax.html#comments)
 * - [(String template)](https://kotlinlang.org/docs/strings.html#string-templates)
 *
 * ## General Resources for Kotlin:
 * - [API documentation](https://kotlinlang.org/docs/api-references.html)
 * - [General documentation with good examples](https://kotlinlang.org/docs/home.html)
 **/
fun main() {

    // Print
    print("Hello ")
    println("World!")
    println("What's your name?")

    /*
    * Read
    * name
    * */
    val name = readln()

    // String template
    println("Hi, $name!")
}
