package io.michaelcruz.emoji_buddy

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration

class EmojiBuddyConfiguration() : Configuration() {
    @JsonProperty("template")
    var template: String= "unknown"

    @JsonProperty("defaultName")
    var defaultName: String= "unknown"
}
