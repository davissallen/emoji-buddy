package io.michaelcruz.b1_http_server.notes

interface Driveable {
    fun drive()
}

interface Buildable {
    val timeRequired: Int
    fun build()
}

class Car(val color: String): Driveable, Buildable {
    override val timeRequired: Int = 120

    override fun drive() {
        println("Driving car...")
    }

    override fun build() {
        println("Builr a shinny car.")
    }
}

class Motorcycle(val color: String): Driveable {
    override fun drive() {
        println("Driving motorcycle...")
    }
}

fun main(args: Array<String>) {
    val car: Driveable = Car("blue")
    car.drive()
    val motorcycle: Driveable = Motorcycle("red")
    motorcycle.drive()
}