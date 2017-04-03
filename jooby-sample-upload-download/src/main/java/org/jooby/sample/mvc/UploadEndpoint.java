package org.jooby.sample.mvc;

import org.jooby.Upload;
import org.jooby.mvc.POST;
import org.jooby.mvc.Path;
import org.jooby.sample.UploadDownloadSampleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public final class UploadEndpoint {
  private static final Logger log = LoggerFactory.getLogger(UploadEndpoint.class);
  private static final String ERROR = "Upload error: %s.";

  @POST
  @Path("mvc/upload")
  public String apply(Upload sampleFile) {
    try {
      final File file = sampleFile.file();
      log.info("MVC Uploaded file size: " + file.length());

      return "Completed!";
    } catch (IOException e) {
      final String error = String.format(ERROR, e.getMessage());
      throw new UploadDownloadSampleException(error, e);
    }
  }
}
