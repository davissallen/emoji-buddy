package io.michaelcruz.b1_http_server.notes

abstract class Thing(val topic: String, val frequency: Int) {
    open fun doThing() {
        println("We're doing the thing $frequency times from the abstract class that is $topic.")
    }
}

interface Thingable {
    fun doThing() {
        println("Doing the thing in the other thing.")
    }
}

open class ChildThing() : Thing("cool stuff", 5), Thingable {
    override final fun doThing() {
        super<Thing>.doThing()
        super<Thingable>.doThing()
        println("How neat is that?")
    }
}

fun main(args: Array<String>) {
    val thing = ChildThing()
    thing.doThing()
}