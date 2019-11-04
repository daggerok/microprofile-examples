package com.github.daggerok;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.logging.Logger;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("v1")
@ApplicationScoped
@Produces(APPLICATION_JSON)
public class SystemPropertiesResource {

  private static final Logger log = Logger.getLogger(SystemPropertiesResource.class.getName());

  @GET
  @Path("")
  public JsonObject index() {
    log.info("index");
    JsonObjectBuilder builder = Json.createObjectBuilder();
    System.getProperties().forEach((key, value) -> builder.add((String) key, (String) value));
    return builder.build();
  }

  @GET
  @Path("props")
  public JsonObject props() {
    log.info("props");
    JsonObjectBuilder builder = Json.createObjectBuilder();
    System.getProperties().forEach((key, value) -> builder.add((String) key, (String) value));
    return builder.build();
  }

  @GET
  @Path("{path}")
  public JsonObject path(@PathParam("path") final String path) {
    log.info("path: " + path);
    JsonObjectBuilder builder = Json.createObjectBuilder();
    System.getProperties().stringPropertyNames().stream()
          .filter(prop -> prop.trim().toLowerCase().contains(path.trim().toLowerCase()))
          .forEach(prop -> builder.add(prop, System.getProperty(prop)));
    return builder.build();
  }
}
