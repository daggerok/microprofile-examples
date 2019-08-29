package daggerok.app;

import io.smallrye.reactive.messaging.annotations.Emitter;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import java.util.Map;

import static java.util.Collections.singletonMap;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("")
@RequestScoped
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class MyResource {

    @Inject
    MyBean myBean;

    @Inject
    Event<String> messages;

    @GET
    @Path("")
    public Response hello() {
        myBean.getMessages().add("ololo");
        myBean.getMessages().add("trlolo");
        messages.fire("Hello!");
        return Response.ok()
                       .entity(singletonMap("result", "Hey!"))
                       .build();
    }
}
