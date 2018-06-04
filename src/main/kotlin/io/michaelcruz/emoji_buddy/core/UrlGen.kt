package io.michaelcruz.emoji_buddy.core

import redis.clients.jedis.Jedis
import java.lang.reflect.Array.set
import java.util.*

class UrlGen {
    val redis: Jedis = Jedis()

    fun createUniqueString() : String {
        var randomString: String = EmojiGen().getEmojis()
        if (!redis.exists("short." + randomString)) {
            return randomString
        } else {
            for (i in 1..5) {
                this.createUniqueString()
            }
            return "CRITICAL ERROR! Please phone the president."
        }
    }
}