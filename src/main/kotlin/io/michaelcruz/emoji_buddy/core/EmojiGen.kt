package io.michaelcruz.emoji_buddy.core

import io.michaelcruz.emoji_buddy.EmojiCodeSheet.*
import java.util.*
import java.util.Objects

class EmojiGen {
//    val emojiStore: ArrayList<String> = arrayListOf("💩", "👍", "🎉", "\uD83D\uDE0A", "\uD83D\uDE0E", "\uD83D\uDE00", "❤️", "\uD83D\uDE0D", "\uD83D\uDE02" )
    val emojiStore : MutableList<String> = arrayListOf()

    val activities = enumValues<ActivityEmoji>()
    val flags = enumValues<FlagsEmoji>()
    val food = enumValues<FoodEmoji>()
    val nature = enumValues<NatureEmoji>()
    val objects = enumValues<ObjectsEmoji>()
    val people = enumValues<PeopleEmoji>()
    val symbols = enumValues<SymbolsEmoji>()
    val travel = enumValues<TravelEmoji>()

    fun buildEmojiList()  {
        activities.forEach() {
            emojiStore.add(it.text)
        }
        flags.forEach() {
            emojiStore.add(it.text)
        }
        food.forEach() {
            emojiStore.add(it.text)
        }
        nature.forEach() {
            emojiStore.add(it.text)
        }
        objects.forEach() {
            emojiStore.add(it.text)
        }
        people.forEach() {
            emojiStore.add(it.text)
        }
        symbols.forEach() {
            emojiStore.add(it.text)
        }
        travel.forEach() {
            emojiStore.add(it.text)
        }
    }

    fun getEmojis() : String {
        buildEmojiList()
        val emojiYeah: String = Random().ints(5, 0, emojiStore.size)
                .mapToObj { emojiStore.get(it) }
                .toArray()
                .joinToString("")
        return emojiYeah
    }
}