package com.github.daggerok;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EndpointIT {

  @Test
  public void testServlet() throws Exception {
    HttpClient httpClient = new HttpClient();
    GetMethod httpGetMethod = new GetMethod(getServletUrl());
    try {
      int actualStatusCode = httpClient.executeMethod(httpGetMethod);
      int expectedStatusCode = HttpStatus.SC_OK;
      assertEquals("HTTP GET failed", expectedStatusCode, actualStatusCode);
      String response = httpGetMethod.getResponseBodyAsString(1000);
      assertTrue("Unexpected response body",
                 response.contains("Hello, Gradle!"));
    } finally {
      httpGetMethod.releaseConnection();
    }
  }

  private static String getServletUrl() {
    String port = System.getProperty("liberty.test.port");
    String warName = System.getProperty("war.name");
    return "http://127.0.0.1:" + port + "/" + warName + "/" + "servlet";
  }
}
