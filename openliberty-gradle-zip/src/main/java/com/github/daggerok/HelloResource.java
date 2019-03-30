package com.github.daggerok;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import java.util.logging.Logger;

import static java.util.Collections.singletonMap;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("v1")
@ApplicationScoped
@Produces(APPLICATION_JSON)
public class HelloResource {

  private static final Logger log = Logger.getLogger(HelloResource.class.getName());

  @GET
  @Path("")
  public Response index() {
    log.info("index");
    return Response.ok(singletonMap("hello", "world")).build();
  }

  @GET
  @Path("{path}")
  public Response get(@PathParam("path") String path) {
    log.info("path: " + path);
    return Response.ok(singletonMap("hello", path)).build();
  }
}
