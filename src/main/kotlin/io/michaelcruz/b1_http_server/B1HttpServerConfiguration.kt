package io.michaelcruz.b1_http_server

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration

class B1HttpServerConfiguration() : Configuration() {
    @JsonProperty("template")
    var template: String="%s"

    @JsonProperty("defaultName")
    var defaultName: String="Stranger"
}
