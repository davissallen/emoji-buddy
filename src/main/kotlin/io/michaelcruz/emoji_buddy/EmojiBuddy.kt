package io.michaelcruz.emoji_buddy

import io.dropwizard.Application
import io.dropwizard.assets.AssetsBundle
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import io.michaelcruz.emoji_buddy.resources.EmojiBuddyResource
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
        bootstrap.addBundle( AssetsBundle("/assets", "/hi", "index.html", "static"));
    }



    override fun run(config: EmojiBuddyConfiguration, env: Environment) {
        val resource =  EmojiBuddyResource(config.template, config.defaultName)
        env.jersey().register(resource)
    }

}

