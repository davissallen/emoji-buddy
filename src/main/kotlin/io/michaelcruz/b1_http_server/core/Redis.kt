package io.michaelcruz.b1_http_server.core

import redis.clients.jedis.Jedis

open class Redis(open val thing: String? = null, open val otherThing: Int? = null) : Jedis() {
    init {
        println("Redis object created.")
    }

    fun set(thing: String, otherThing: Int) {
        println(thing)
        println(otherThing)
    }
}

fun main(args: Array<String>) {
    val redis = Redis()
    redis.ping()
    println("Connection to server successful.")
    redis.set("sup dude", 99)
}


