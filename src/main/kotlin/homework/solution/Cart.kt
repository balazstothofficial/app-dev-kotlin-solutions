package homework.solution


data class Cart(
    val shop: Shop,
    val items: Map<Item, UInt> = emptyMap(),
    private val allDiscounts: List<Discount> = emptyList()
) {
    init {
        require(shop.prices.keys.containsAll(items.keys))
    }

    val discounts by lazy {
        allDiscounts.clean()
    }

    val price: Euro by lazy {
        val price = items
            .map { (item, amount) -> shop.prices[item]!! * amount }
            .fold(0u.euro, Euro::plus)

        discounts
            .fold(price) { total, price -> price.apply(this, total) }
    }
}

operator fun Cart.plus(other: Pair<Item, UInt>): Cart {
    val currentAmount = items[other.first] ?: 0u
    val pair = other.copy(second = other.second + currentAmount)

    return copy(items = items + pair)
}

operator fun Cart.plus(other: Item): Cart = this + (other to 1u)

operator fun Cart.plus(other: Discount): Cart = copy(allDiscounts = this.discounts + other)

operator fun Cart.plus(other: List<Discount>): Cart = copy(allDiscounts = this.discounts + other)
