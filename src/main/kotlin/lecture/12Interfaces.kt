package lecture

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

}
