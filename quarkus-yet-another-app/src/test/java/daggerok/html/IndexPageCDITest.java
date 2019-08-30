package daggerok.html;

import daggerok.Service;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.net.URL;

@QuarkusTest
class IndexPageCDITest {

    @TestHTTPResource("/index.html")
    URL url;

    @Inject
    Service service;

    @Test
    void testIndexHtml() {
        String content = service.readContentFrom(url);
        Assertions.assertTrue(content.contains("<h2>Why do you see this?</h2>"));
    }
}
