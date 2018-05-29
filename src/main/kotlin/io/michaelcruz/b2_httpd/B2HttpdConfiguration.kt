package io.michaelcruz.b2_httpd

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration

public class B2HttpdConfiguration() : Configuration() {
    @JsonProperty("template")
    public var template: String="%s"

    @JsonProperty("defaultName")
    public var defaultName: String="Stranger"
}
