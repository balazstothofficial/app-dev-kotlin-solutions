package lecture.solution

/**
 * # Interfaces
 *
 * Interfaces are a good way to introduce abstractions and increase code reusability and flexibility.
 *
 * ## Tasks:
 * - Create an interface [PaymentMethod], with a function [PaymentMethod.fees] of type `() -> Double`.
 * - Create an object [Cash] and data classes [CreditCard] and [PayPal].
 * - Create for [CreditCard] and [PayPal] the properties [CreditCard.number],
 *   [CreditCard.expiryDate], and [PayPal.email] as constructor parameters.
 * - Create for [CreditCard] and [PayPal] the member functions [CreditCard.verify] and
 *   [PayPal.goToPaypal] of type `() -> Unit`.
 *   (The signature of the member functions is just a mock.
 *   What could be a useful signatures for them?)
 * - Let [Cash], [CreditCard] and [PayPal] implement [PaymentMethod].
 * - [CreditCard]s can have different fees.
 *   Let the class take a constructor parameter [CreditCard.vendor] of type [PaymentMethod] and
 *   use it's fees using delegation.
 * - Create a function [pay], which takes a [PaymentMethod] as parameter.
 *   If the payment method is [Cash] the function does nothing.
 *   If the payment method is [PayPal] it calls [PayPal.goToPaypal].
 *   If the payment method is [CreditCard] it calls [CreditCard.verify].
 * - Make [PaymentMethod] a sealed interface and simplify [pay] accordingly.
 * - Create an interface [IntPredicate] with one function [IntPredicate.test] of
 *   type `(Int) -> Boolean`.
 * - Create an anonymous implementation of [IntPredicate] such that [IntPredicate.test]
 *   returns true for all even numbers.
 * - Make [IntPredicate] a functional interface.
 *   Create an anonymous implementation of [IntPredicate] such that [IntPredicate.test]
 *   returns true for all odd numbers using a lambda expression.
 * - Generalize [IntPredicate] to an interface [Predicate], where the type of [Predicate.test] is
 *   `(T) -> Boolean`.
 *
 * ## Resources:
 * - [Interfaces](https://kotlinlang.org/docs/interfaces.html)
 * - [Sealed interfaces](https://kotlinlang.org/docs/sealed-classes.html)
 * - [Anonymous interface implementations](https://kotlinlang.org/docs/object-declarations.html#inherit-anonymous-objects-from-supertypes)
 * - [Functional interfaces](https://kotlinlang.org/docs/fun-interfaces.html)
 * - [Generics](https://kotlinlang.org/docs/generics.html)
 */
fun main() {
    val isEven = object : IntPredicate {
        override fun test(int: Int): Boolean {
            return int % 2 == 0
        }
    }

    val isEvenBetter  = IntPredicate { it % 2 == 0 }
    val isOdd = Predicate<Int>{ it % 2 == 1 }

    isOdd.test(1)
}

sealed interface PaymentMethod {
    fun fees(): Double
}

data object Cash: PaymentMethod {
    override fun fees() = 0.0
}

data class PayPal(val email: String) : PaymentMethod {
    fun goToPaypal() {
        println("Go to PayPal website for $email.")
    }

    override fun fees() = 0.01
}

data class CreditCard(
    val number: String,
    val expiryDate: String,
    val vendor: PaymentMethod
) : PaymentMethod by vendor {
    fun verify() {
        println("Verify credit card: $number, $expiryDate")
    }
}

fun PaymentMethod.payNotSealed() {
    when (this) {
        is CreditCard -> {
            verify()
        }

        is PayPal -> {
            goToPaypal()
        }

        is Cash -> {

        }

        else -> {
            error("Shouldn't reach here!")
        }
    }
}

fun PaymentMethod.pay() = when (this) {
    is Cash -> {}
    is CreditCard -> verify()
    is PayPal -> goToPaypal()
}

fun interface IntPredicate {
    fun test(int: Int): Boolean
}

// Works the same with classes (you can have multiple generics)
// When using generics variance can play a role => in/ out
fun interface Predicate<T> {
    fun test(value: T): Boolean
}
