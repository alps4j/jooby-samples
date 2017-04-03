package org.jooby.sample;

import org.apache.commons.io.IOUtils;
import org.jooby.test.JoobyRule;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class UploadDownloadSampleMainTest {
  @ClassRule
  public static JoobyRule bootstrap = new JoobyRule(new UploadDownloadSampleMain());

  @Test
  public void mvcDownload() throws Exception {
    final InputStream image = this.getClass().getClassLoader().getResourceAsStream("logo_jooby.png");
    final int expected = IOUtils.toByteArray(image).length;
    final InputStream input = when().get("/mvc/download")
      .then()
      .log().ifValidationFails()
      .extract()
      .asInputStream();

    final ByteArrayOutputStream output = new ByteArrayOutputStream();
    IOUtils.copy(input, output);
    IOUtils.closeQuietly(output);
    IOUtils.closeQuietly(input);

    assertEquals(expected, output.size());
  }

  @Test
  public void scriptDownload() throws Exception {
    final InputStream image = this.getClass().getClassLoader().getResourceAsStream("logo_jooby.png");
    final int expected = IOUtils.toByteArray(image).length;
    final InputStream input = when().get("/script/download")
      .then()
      .log().ifValidationFails()
      .extract()
      .asInputStream();

    final ByteArrayOutputStream output = new ByteArrayOutputStream();
    IOUtils.copy(input, output);
    IOUtils.closeQuietly(output);
    IOUtils.closeQuietly(input);

    assertEquals(expected, output.size());
  }

  @Test
  public void mvcUpload() throws Exception {
    final URL path = this.getClass().getClassLoader().getResource("logo_jooby.png");
    Assert.assertNotNull(path);
    final URI uri = path.toURI();
    final File file = new File(uri);

    given()
      .multiPart("sampleFile", file)
      .formParam("sampleFile", uri.toASCIIString())
      .contentType("multipart/form-data")
      .expect()
      .body(equalTo("Completed!"))
      .when()
      .post("/mvc/upload")
      .then()
      .statusCode(200);
  }

  @Test
  public void scriptUpload() throws Exception {
    final URL path = this.getClass().getClassLoader().getResource("logo_jooby.png");
    Assert.assertNotNull(path);
    final URI uri = path.toURI();
    final File file = new File(uri);

    given()
      .multiPart("sampleFile", file)
      .formParam("sampleFile", uri.toASCIIString())
      .contentType("multipart/form-data")
      .expect()
      .body(equalTo("Completed!"))
      .when()
      .post("/script/upload")
      .then()
      .statusCode(200);
  }
}