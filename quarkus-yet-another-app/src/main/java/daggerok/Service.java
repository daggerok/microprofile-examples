package daggerok;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

@ApplicationScoped
public class Service {

    @LogMe
    @Inject
    Logger log;

    @SneakyThrows
    public String readContentFrom(URL url) {
        log.info("reading from {}", url);
        @Cleanup InputStream is = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        return reader.lines().collect(Collectors.joining("\n"));
    }
}
