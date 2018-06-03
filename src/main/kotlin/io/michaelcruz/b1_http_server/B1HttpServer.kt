package io.michaelcruz.b1_http_server

import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import io.michaelcruz.b1_http_server.resources.B1HttpServerResource
import io.michaelcruz.b1_http_server.health.TemplateHealthCheck
import redis.clients.jedis.Jedis

class B1HttpServer() : Application<B1HttpServerConfiguration>() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            B1HttpServer().run(*args)
            val jedis = Jedis()
            println(jedis.ping())
            jedis.ping()
            println("Connection to server successful.")
        }
    }

    override fun initialize(bootstrap: Bootstrap<B1HttpServerConfiguration>) {
        // Don't do anything
    }

    override fun run(config: B1HttpServerConfiguration, env: Environment) {
        val resource =  B1HttpServerResource(config.template, config.defaultName)
        val healthCheck = TemplateHealthCheck(config.template)

        env.healthChecks().register("template", healthCheck)
        env.jersey().register(resource)
    }

}

