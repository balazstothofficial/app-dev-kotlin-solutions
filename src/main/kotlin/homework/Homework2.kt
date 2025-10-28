package homework

/**
 * # Homework 2: Modeling a Shop
 *
 * ## Requirements
 * 1) Prices
 *    - Create a class `Euro` that wraps an unsigned integer of cents (e.g., 90 = €0.90).
 *    - Implement operators so you can add, subtract, and multiply amounts.
 *
 * 2) Items
 *    - Model the items of the shop.
 *    - The items should be identified by a [String] ID (e.g., Item("apple")).
 *
 * 3) Shop
 *    - Model a shop that maps items to their prices.
 *
 * 4) Shopping cart
 *    - A cart contains items (with quantities) and can compute the total price.
 *
 * 5) Discounts
 *    - Support three discount kinds:
 *      - Percentage (e.g., 20% off the current total)
 *      - Fixed amount off (e.g., €5.00 off)
 *      - Bundle (e.g., “Buy 3, pay 2” for a specific item)
 *        - Example: You have 7 apples in your cart and a “Buy 3, pay 2” bundle for apples.
 *          Then you have to pay for 5 apples.
 *
 * 6) Cart with discounts
 *    - You can place discounts into a cart.
 *    - Discounts apply to the entire cart.
 *
 * 7) Total calculation
 *    - First sum the price of all items.
 *    - Apply discounts in this order: Bundle → Fixed → Percentage.
 *    - If multiple bundle offers target the same item, keep only the single bundle
 *      that yields the most free items.
 *
 * 8) Operators on Cart
 *    - Provide these operators:
 *      - `Cart.plus(Pair<Item, UInt>): Cart`
 *      - `Cart.plus(Item): Cart`
 *      - `Cart.plus(Discount): Cart`
 *      - `Cart.plus(List<Discount>): Cart`
 *
 * 9) Structure
 *    - Split your implementation across multiple files.
 *    - Use only data classes (or value classes) and sealed interfaces.
 *
 * 10) Create an example scenario
 *    - Shop prices: banana €0.90, apple €0.60, golden fig €16.00.
 *    - Cart contents: 3 bananas, 7 apples, 2 golden figs.
 *    - Discounts in cart:
 *        - 20% off
 *        - Buy 3 apples for the price of 2
 *        - €1.50 off
 *    - Print the total.
 *    - Expected output: €28.96
 *
 * ## Resources
 * - [Value classes](https://kotlinlang.org/docs/inline-classes.html)
 */
fun main() {

}
