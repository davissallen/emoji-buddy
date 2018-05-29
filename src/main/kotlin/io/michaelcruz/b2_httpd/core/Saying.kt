package io.michaelcruz.b2_httpd.core

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.Length

data class Saying(@JsonProperty val id: Long, @JsonProperty val content: String)