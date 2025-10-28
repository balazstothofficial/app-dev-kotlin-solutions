package lecture.solution

/**
 * # Exceptions
 * Kotlin inherited exceptions from Java, but only has unchecked exceptions.
 * My advice: Try to avoid throwing any exceptions on your own.
 *
 * ## Tasks:
 * - What are alternatives to using exceptions?
 * - Can the code crash? Fix any crashes.
 *
 * ## Resources:
 * - [Exceptions](https://kotlinlang.org/docs/exceptions.html)
 * - [(Infix functions)](https://kotlinlang.org/docs/functions.html#infix-notation)
 */
fun main() {
    // Exceptions
    fun checkName(name: String) {
        require(name != "")

        val names = name.split(" ")

        check(names.size > 1)

        when (names.size) {
            2 -> println("Has first and last name")
            3 -> println("Has first, middle and last name")
            else -> throw IllegalStateException("Can't reach here") // or: error
        }
    }

    try {
        println("What's your full name?")
        val name = readln()
        checkName(name)

        /*
            Example on how to *not* handle exceptions in your code!
            Always try to resolve the issues.
            Here a good way would be to ask for a name again.
        */
    } catch (e: IllegalStateException) {
        println("One can have more than 3 names. Exception: \"$e\"")
    }/* catch (e: IllegalArgumentException) {
        println("Name was empty. Exception: \"$e\"")
    }*/
    finally {
        println("BYE!")
    }
}
