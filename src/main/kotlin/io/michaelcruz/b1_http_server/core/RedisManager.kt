package io.michaelcruz.b1_http_server.core

import redis.clients.jedis.Jedis
import java.util.*

class RedisManager {
    val redis: Jedis = Jedis()

    fun getUrl(shortUrl: String) : String? {
        val dict = redis.hgetAll("short." + shortUrl)
        return dict.get("url")
    }

    // build random string generator
    fun setUrl(url: String) : String? {
        val randomString: String = "asdf"
        val shortUrl: String = "short." + randomString
        redis.hset(shortUrl, "url", url)
        redis.hset(shortUrl, "date", Date().toString())
        return randomString
    }
}


