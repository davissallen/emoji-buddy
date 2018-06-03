package io.michaelcruz.b1_http_server.core

import redis.clients.jedis.Jedis
import java.util.*

class RedisManager {
    val redis: Jedis = Jedis()

    // build random string generator
    fun setUrl(url: String) : String {
        val randomString: String = "654321"
        val shortUrl: String = "short." + randomString
        redis.hset(shortUrl, "url", url)
        redis.hset(shortUrl, "date", Date().toString())
        return randomString
    }
    fun getUrl(shortUrl: String) {
        redis.hgetAll(shortUrl)
    }
}


