package io.michaelcruz.b1_http_server.core

import redis.clients.jedis.Jedis
import java.util.*

class RedisManager {
    val redis: Jedis = Jedis()

    // build random string generator
    fun setUrl(url: String) {
        redis.hset("short.654321", "url", url)
        redis.hset("short.654321", "date", Date().toString())
    }
    fun getUrl(shortUrl: String) {
        redis.hgetAll(shortUrl)
    }
}


