package io.michaelcruz.b1_http_server.resources

import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import java.util.concurrent.atomic.AtomicLong
import com.google.common.base.Optional
import io.michaelcruz.b1_http_server.core.RedisManager
import io.michaelcruz.b1_http_server.core.Response
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.QueryParam
import javax.ws.rs.*

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
class B1HttpServerResource(val template: String, val defaultName: String) {
    var counter = AtomicLong()
    val redis = RedisManager()


    @GET
    @Path("/{short}")
    fun fetchUrl(@PathParam("short") short: String): Response {
        val redirectUrl = redis.getUrl(short).toString()
        // redirect here
        return Response(
                id = counter.incrementAndGet(),
                url = redirectUrl
        )
    }


    @POST
    @Path("/fetchurl")
    fun fetchUrl(@QueryParam("url") url: Optional<String>): Response {
        val value = java.lang.String.format(template, url.or(defaultName))
        val randomString = redis.setUrl(value.toString())

        return Response(
                id = counter.incrementAndGet(),
                url = "http://localhost:8080/" + randomString
        )
    }
}