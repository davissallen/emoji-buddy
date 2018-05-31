package io.michaelcruz.b1_http_server.house

// note default value on class
class House(val height: Double, val color: String, val price: Int = 50000) {
    fun print() {
        println("House [height=$height, color=$color, price=$price]")
    }
}

fun main(args: Array<String>) {
    val house = House(height = 4.5, color = "Blue", price = 15000)
    val redHouse = House(color = "Blue", height = 4.5, price = 15000)
    val yellowHouse = House(color = "Yellow", height = 2.5)

    house.print()
    redHouse.print()
    yellowHouse.print()
}