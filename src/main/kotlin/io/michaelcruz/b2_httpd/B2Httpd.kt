package main.kotlin.io.michaelcruz.b2_httpd

import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import io.michaelcruz.b2_httpd.resources.HelloWorldResource
import io.michaelcruz.b2_httpd.health.TemplateHealthCheck

class B2Httpd() : Application<B2HttpdConfiguration>() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            B2Httpd().run(*args)
        }
    }

    override fun initialize(bootstrap: Bootstrap<B2HttpdConfiguration>) {
        // Don't do anything
    }

    override fun run(config: B2HttpdConfiguration, env: Environment) {
        val resource =  B2HttpdResource(config.template, config.defaultName)
        val healthCheck = TemplateHealthCheck(config.template)

        env.healthChecks().register("template", healthCheck)
        env.jersey().register(resource)
    }

}