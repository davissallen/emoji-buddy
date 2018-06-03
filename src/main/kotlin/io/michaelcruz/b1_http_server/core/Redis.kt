package io.michaelcruz.b1_http_server.core

import redis.clients.jedis.Jedis
import java.util.*

open class Redis(open val thing: String? = null, open val otherThing: Int? = null) : Jedis() {
    init {
        println("Redis object created.")
    }
}

fun main(args: Array<String>) {
    val redis = Redis()
    println(redis.ping())
    redis.ping()
    println("Connection to server successful.")
    println("Look at the set...")

    redis.hset("short.788787", "url", "https://www.google.com")
    redis.hset("short.788787", "date", Date().toString())
    redis.hset("short.788787", "foo", "bar")

    println("Look at the get...")
    println(redis.hgetAll("short.788787"))
}


