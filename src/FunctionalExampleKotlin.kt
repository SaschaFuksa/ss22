data class Fruit(val name: String, val weight: Int)

fun main() {
    imperativeExample()
    functionalExample()
}

private fun imperativeExample() {
    val fruits = listOf(
        Fruit("Mango", 12), Fruit("Cherry", 8), Fruit("Mango", 9), Fruit("Cherry", 7), Fruit("Cherry", 6)
    )

    val cherries = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (fruit.name == "Cherry") {
            cherries += fruit
        }
    }

    val smallCherries = mutableListOf<Fruit>()
    for (cherries in cherries) {
        if (cherries.weight <= 7) {
            smallCherries += cherries
        }
    }

    println(cherries.size)
    println(smallCherries.size)
}

private fun functionalExample() {
    val fruits = listOf(
        Fruit("Mango", 12), Fruit("Cherry", 8), Fruit("Mango", 9), Fruit("Cherry", 7), Fruit("Cherry", 6)
    )

    val smallCherries = fruits
        .filter { it.name == "Cherry" }
        .filter { it.weight <= 7 }

    println(smallCherries.size)
}