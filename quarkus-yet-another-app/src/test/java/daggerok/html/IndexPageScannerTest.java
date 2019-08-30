package daggerok.html;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

@QuarkusTest
class IndexPageScannerTest {

    @TestHTTPResource("index.html")
    URL url;

    @Test
    void testIndexHtml() throws Exception {
        try (InputStream is = url.openStream()) {
            Scanner scanner = new Scanner(is).useDelimiter("\\A");
            String contents = scanner.hasNext() ? scanner.next() : "";
            Assertions.assertTrue(contents.contains("<h2>Why do you see this?</h2>"));
        }
    }
}
