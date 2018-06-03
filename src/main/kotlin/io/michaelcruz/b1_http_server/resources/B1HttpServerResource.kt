package io.michaelcruz.b1_http_server.resources

import javax.ws.rs.core.MediaType
import java.util.concurrent.atomic.AtomicLong
import com.codahale.metrics.annotation.Timed
import com.google.common.base.Optional
import io.dropwizard.jersey.PATCH
import io.michaelcruz.b1_http_server.core.RedisManager
import io.michaelcruz.b1_http_server.core.Response
import javax.ws.rs.POST
import javax.ws.rs.*

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
class B1HttpServerResource(val template: String, val defaultName: String) {
    var counter = AtomicLong()
    val redis = RedisManager()

    @Timed
    @Path("/{short}")
    @PATCH
    fun fetchUrl(@PathParam("short") short: String): Response {

        return Response(
                id = counter.incrementAndGet(),
                url = short + "you did the thing"
        )
    }

    @Timed
    @Path("/fetchurl")
    @POST
    fun fetchUrl(@QueryParam("url") url: Optional<String>): Response {
        val randomString = redis.setUrl(url.toString())

        return Response(
                id = counter.incrementAndGet(),
                url = "http://localhost:8080/" + randomString
        )
    }
}