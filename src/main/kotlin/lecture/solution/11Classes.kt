package lecture.solution

import lecture.solution.Gender.Male
import kotlin.reflect.KProperty

/**
 * # Classes
 * (Data) Classes are good way to structure your data.
 *
 * ## Tasks:
 * - Create a class [Person], that has a first name, a last name and an age.
 * - Use a primary constructor for [Person]
 * - Create a secondary constructor, which just takes a full name and an age.
 * - Create a public property [Person.name] that combines the first and last names.
 * - Create a member function [Person.congratulate] that prints a nice message for round birthdays.
 * - Create a static property [Person.Description] that describes the class [Person].
 * - Implement the method [Person.toString].
 * - Convert [Person] to a data class.
 *   Is [Person.toString] still necessary?
 *   What other benefits does a data class have?
 * - Create an object [People], which stores some important people.
 * - Imagine that [Person.name] takes long to compute.
 *   Use property delegation and [lazy] to make sure, that it is just computed when needed.
 * - Understand property delegation: Create your own implementation of [lazy].
 *   You don't have to care about thread safety.
 * - Create an enum [Gender] and add a public property to [Person], that uses it.
 *
 * ## Resources:
 * - [Classes](https://kotlinlang.org/docs/classes.html)
 * - [Constructors](https://kotlinlang.org/docs/classes.html#constructors)
 * - [Properties](https://kotlinlang.org/docs/properties.html)
 * - [Member functions](https://kotlinlang.org/docs/functions.html#member-functions)
 * - [Companion objects](https://kotlinlang.org/docs/object-declarations.html#companion-objects)
 * - [Constants](https://kotlinlang.org/docs/properties.html#compile-time-constants)
 * - [Data classes](https://kotlinlang.org/docs/data-classes.html)
 * - [Objects](https://kotlinlang.org/docs/object-declarations.html)
 * - [Delegated Properties](https://kotlinlang.org/docs/delegated-properties.html)
 * - [Generics](https://kotlinlang.org/docs/generics.html)
 * - [Enum](https://kotlinlang.org/docs/enum-classes.html)
 */
fun main() {
    // Example Person:
    val naivePerson = NaivePerson("Hans Peter", 40, Male)
    println(naivePerson.firstName)
    println(naivePerson.name)
    println(NaivePerson.Description)
    naivePerson.congratulate()

    // Benefits of a data class:
    val person = Person("Hans", "Peter", 40, Male)
    // toString
    println(naivePerson)
    println(person)
    // copy
    println(person.copy(firstName = "Lothar"))
    // equals (Attention with arrays in data classes!)
    println(Person("Hans Peter", 40, Male) == Person("Hans Peter", 40, Male))
    println(NaivePerson("Hans Peter", 40, Male) == NaivePerson("Hans Peter", 40, Male))

    class Local {
        fun sth() = "Works!"
    }

    println(Local().sth())
}

class NaivePerson {

    val firstName: String
    val lastName: String
    val age: Int

    val gender: Gender

    constructor(firstName: String, lastName: String, age: Int, gender: Gender) {
        this.firstName = firstName
        this.lastName = lastName
        this.age = age
        this.gender = gender
    }

    constructor(name: String, age: Int, gender: Gender) : this(
        firstName = name.split(" ").first(),
        lastName = name.split(" ").last(),
        age = age,
        gender = gender
    )

    val name: String
        get() = "$firstName $lastName"
    /*set(name) {
        this.firstName = name.split(" ").first()
        this.lastName = name.split(" ").last()
    }*/

    fun congratulate() {
        if (age % 10 == 0) {
            println("You were born in ${2025 - age}. You have a round birthday this year!")
        }
    }

    // static methods/ fields
    companion object {
        val Description = "A class representing a person"
    }
}

data class Person(val firstName: String, val lastName: String, val age: Int, val gender: Gender) {

    constructor(name: String, age: Int, gender: Gender) : this(
        firstName = name.split(" ").first(),
        lastName = name.split(" ").last(),
        age = age,
        gender = gender
    )

    val name: String by lazy { "$firstName $lastName" }

    private val bornIn
        get() = 2025 - age

    fun congratulate() {
        if (age % 10 == 0) {
            println("You were born in $bornIn. You have a round birthday this year!")
        }
    }

    // static methods/ fields
    companion object {
        const val Description = "A class representing a person"
    }
}

enum class Gender {
    Female, Male, Divers
}

object People {
    val thomas = Person("Thomas", "Müller", 40, Male)
}

class NaiveLazy<T : Any>(private val calculate: () -> T) {
    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        if (value != null) return value!!
        value = calculate()
        return value!!
    }
}

/**
 *  This would be a better implementation.
 *  In practice just use [lazy].
 *  There are still short-comings of this implementation. Can you find them?
 */
class ThreadSafeLazy<T : Any> (private val calculate: () -> T) {
    @Volatile private var value: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        val value = value
        if (value != null) return value

        synchronized(this) {
            var value = this.value
            if (value == null) {
                value = calculate()
                this.value = value
            }
            return value
        }

    }
}
