package io.michaelcruz.b1_http_server

import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import io.michaelcruz.b1_http_server.resources.EmojiBuddyResource
import redis.clients.jedis.Jedis

class EmojiBuddy() : Application<EmojiBuddyConfiguration>() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            EmojiBuddy().run(*args)
            val jedis = Jedis()
            println(jedis.ping())
            jedis.ping()
            println("Connection to server successful.")
        }
    }

    override fun initialize(bootstrap: Bootstrap<EmojiBuddyConfiguration>) {
        // Don't do anything
    }

    override fun run(config: EmojiBuddyConfiguration, env: Environment) {
        val resource =  EmojiBuddyResource(config.template, config.defaultName)
        env.jersey().register(resource)
    }

}

