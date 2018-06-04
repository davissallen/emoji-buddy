package io.michaelcruz.emoji_buddy.core

import com.fasterxml.jackson.annotation.JsonProperty

data class Response(@JsonProperty val id: Long, @JsonProperty val url: String, @JsonProperty val redirectUrl: String)