package io.michaelcruz.emoji_buddy.core

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
        val uniqueString: String = UrlGen().createUniqueString()
        val key: String = "short." + uniqueString
        redis.hset(key, "url", url)
        redis.hset(key, "date", Date().toString())
        return uniqueString
    }
}


