package io.michaelcruz.b1_http_server.core

import com.fasterxml.jackson.annotation.JsonProperty

data class Saying(@JsonProperty val id: Long, @JsonProperty val content: String)