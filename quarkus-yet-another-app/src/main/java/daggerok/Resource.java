package daggerok;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Slf4j
@Path("/api")
@Produces(MediaType.WILDCARD)
public class Resource {

    @GET
    @Path("/hello")
    public String hello() {
        log.info("hey!");
        return "hello";
    }
}
