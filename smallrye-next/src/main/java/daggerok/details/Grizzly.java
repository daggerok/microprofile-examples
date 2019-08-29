// package daggerok;
//
// import daggerok.app.MyBean;
// import daggerok.app.MyResource;
// import io.vavr.collection.HashSet;
// import io.vavr.control.Try;
// import lombok.extern.log4j.Log4j2;
// import org.glassfish.grizzly.http.server.HttpServer;
// import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
// import org.glassfish.jersey.server.ResourceConfig;
//
// import javax.enterprise.context.ApplicationScoped;
// import javax.ws.rs.core.Application;
// import java.net.URI;
// import java.util.Set;
// import java.util.concurrent.TimeUnit;
//
// @Log4j2
// @ApplicationScoped
// public class Grizzly extends Application {
//
//     @Override
//     public Set<Class<?>> getClasses() {
//         return HashSet.of(MyResource.class, MyBean.class)
//                       .toJavaSet();
//     }
//
//     public static void main(String[] args) {
//
//         ResourceConfig resourceConfig = ResourceConfig.forApplicationClass(MainNonReactive.class);
//         HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(
//                 URI.create("http://127.0.0.1:8080/"), resourceConfig, false);
//
//         Runtime.getRuntime()
//                .addShutdownHook(new Thread(() -> {
//                    httpServer.shutdown(5, TimeUnit.SECONDS);
//                }));
//
//         Try.run(httpServer::start)
//            .onSuccess(aVoid -> log.info("Server started. Use CTRL+C to quit."))
//            .onFailure(throwable -> log.error("oops {}", throwable.getLocalizedMessage()));
//     }
// }
