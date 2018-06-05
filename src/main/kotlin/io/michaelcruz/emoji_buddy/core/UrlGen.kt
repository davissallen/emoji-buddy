package io.michaelcruz.emoji_buddy.core

import redis.clients.jedis.Jedis
import java.lang.reflect.Array.set
import java.util.*
import kotlin.system.exitProcess

class UrlGen {
    val redis: Jedis = Jedis()
    val alert: Throwable = Throwable()
    var result: String = ""

    fun createUniqueString() : String {
        for (i in 1..5)  {
            val randomString: String = EmojiGen().getEmojis()
            if (!redis.exists("short." + randomString)) {
                this.result = randomString
            } else {
                throw alert
            }
        }
        return this.result
    }
}