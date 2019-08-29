package daggerok.app;

import io.smallrye.reactive.messaging.annotations.Emitter;
import io.smallrye.reactive.messaging.annotations.Stream;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.Optional;

import static java.util.Collections.singletonMap;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("")
@RequestScoped
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class CommandGatewayResource {

    @Inject
    @Stream("source")
    Emitter<String> emitter;

    @POST
    @Path("")
    public Response sendMessage(Map<String, String> request) {

        Optional<String> maybeMessage = Optional.ofNullable(request.get("message"));
        maybeMessage.ifPresent(message -> emitter.send(message));

        return maybeMessage.isPresent()

                ? Response.accepted()
                          .entity(singletonMap("result", String.format("message %s sent.", maybeMessage.get())))
                          .build()

                : Response.status(Response.Status.BAD_REQUEST)
                          .entity(singletonMap("error", "message has not been found in request."))
                          .build();
    }
}
