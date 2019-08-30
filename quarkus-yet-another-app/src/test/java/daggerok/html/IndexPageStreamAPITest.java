package daggerok.html;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

@QuarkusTest
class IndexPageStreamAPITest {

    @TestHTTPResource("/index.html")
    URL url;

    @Test
    void testIndexHtml() throws Exception {
        try (InputStream is = url.openStream()) {
            String contents = new BufferedReader(new InputStreamReader(is))
                    .lines().collect(Collectors.joining("\n"));
            Assertions.assertTrue(contents.contains("<h2>Why do you see this?</h2>"));
        }
    }
}
