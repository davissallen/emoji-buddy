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
import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.UriBuilder



@Path("/")
@Produces(MediaType.APPLICATION_JSON)
class EmojiBuddyResource(val template: String, val defaultName: String) {
    var counter = AtomicLong()
    val redis = RedisManager()


    @GET
    @Path("/{short}")
    fun redirectUrl(@PathParam("short") short: String): javax.ws.rs.core.Response {

        val redirectUrl = redis.getUrl(short).toString()
        val uri2 = UriBuilder.fromUri(redirectUrl).build()
        return javax.ws.rs.core.Response.temporaryRedirect(uri2).build()
    }


    @POST
    @Path("/fetchurl")
    fun fetchUrl(@QueryParam("url") url: Optional<String>): Response {

        val randomString = redis.setUrl(url.get())
        val redirectUrl = redis.getUrl(randomString.toString()).toString()

        return Response(
                id = counter.incrementAndGet(),
                url = "http://localhost:8080/" + randomString,
                redirectUrl = redirectUrl
        )

    }
}