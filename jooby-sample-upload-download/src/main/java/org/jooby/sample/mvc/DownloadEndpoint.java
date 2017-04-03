package org.jooby.sample.mvc;

import org.jooby.Request;
import org.jooby.Response;
import org.jooby.mvc.GET;
import org.jooby.mvc.Path;
import org.jooby.sample.UploadDownloadSampleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;

import static java.util.Objects.nonNull;

public final class DownloadEndpoint {
  private static final Logger log = LoggerFactory.getLogger(DownloadEndpoint.class);
  private static final String JOOBY_LOGO = "logo_jooby.png";
  private static final String ERROR = "MVC Download error: %s.";

  @GET
  @Path("/mvc/download")
  public Response accept(Request request, Response response) {
    try {
      final URL logo = this.getClass().getClassLoader().getResource(JOOBY_LOGO);
      assert nonNull(logo);
      final File file = new File(logo.toURI());
      log.info("MVC Downloading file with size: " + file.length());

      response.status(200).download(file);
      return response;
    } catch (Throwable e) {
      final String error = String.format(ERROR, e.getMessage());
      throw new UploadDownloadSampleException(error, e);
    }
  }
}
