package io.michaelcruz.emoji_buddy.resources

import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import java.util.concurrent.atomic.AtomicLong
import com.google.common.base.Optional
import io.michaelcruz.emoji_buddy.core.RedisManager
import io.michaelcruz.emoji_buddy.core.Response
import org.glassfish.jersey.server.Uri
import java.net.URI
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.QueryParam
import javax.ws.rs.*
import javax.ws.rs.core.UriBuilder



@Path("/")
@Produces(MediaType.APPLICATION_JSON)
class EmojiBuddyResource(val template: String, val defaultName: String) {
    var counter = AtomicLong()
    val redis = RedisManager()
    val alert: Throwable = Throwable()

    @GET
    @Path("/{short}")
    fun redirectUrl(@PathParam("short") short: String): javax.ws.rs.core.Response {

        if (short != "hi") {
            val redirectUrl = redis.getUrl(short).toString()
            val uri2 = UriBuilder.fromUri(redirectUrl).build()
            return javax.ws.rs.core.Response.temporaryRedirect(uri2).build()
        } else {
            throw alert
        }
    }


    @POST
    @Path("/fetchurl")
    fun fetchUrl(@QueryParam("url") url: Optional<URI>): Response {

        val uniqueString = redis.setUrl(url.get().toString())
        val redirectUrl = redis.getUrl(uniqueString.toString()).toString()

        return Response(
                id = counter.incrementAndGet(),
                url = "1jo.me/" + uniqueString,
                redirectUrl = redirectUrl
        )

    }
}