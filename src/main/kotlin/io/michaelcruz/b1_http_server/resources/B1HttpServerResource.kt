package io.michaelcruz.b1_http_server.resources

import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import java.util.concurrent.atomic.AtomicLong
import com.codahale.metrics.annotation.Timed
import javax.ws.rs.GET
import com.google.common.base.Optional
import javax.ws.rs.QueryParam
import io.michaelcruz.b1_http_server.core.Saying

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
class B1HttpServerResource(val template: String, val defaultName: String) {
    var counter = AtomicLong()

    @Timed
    @GET
    fun sayHello(@QueryParam("name") name: Optional<String>): Saying {
        val value = java.lang.String.format(template, name.or(defaultName))
        return Saying(
                id = counter.incrementAndGet(),
                content = value
        )
    }
}