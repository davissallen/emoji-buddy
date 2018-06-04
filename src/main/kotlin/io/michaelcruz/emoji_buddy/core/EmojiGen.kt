package io.michaelcruz.emoji_buddy.core

import java.util.*

class EmojiGen {
    val emojis: ArrayList<String> = arrayListOf("💩", "👍", "🎉", "\uD83D\uDE0A", "\uD83D\uDE0E", "\uD83D\uDE00", "❤️", "\uD83D\uDE0D", "\uD83D\uDE02" )

    fun getEmojis() : String {
        val emojiYeah: String = Random().ints(5, 0, emojis.size)
                .mapToObj { emojis.get(it) }
                .toArray()
                .joinToString("")
        return emojiYeah
    }
}

fun main(args: Array<String>) {


}