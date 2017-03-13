package org.jooby.sample;

import org.jooby.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;

import static java.util.Objects.nonNull;

public class UploadDownloadSampleMain extends Jooby {
  private static final Logger log = LoggerFactory.getLogger(UploadDownloadSampleMain.class);
  private static final String JOOBY_LOGO = "logo_jooby.png";

  {
    use("script")
      .post()
      .post("/upload", (req, res) -> {
        final Upload upload = req.file("sampleFile");
        final File file = upload.file();
        log.info("Uploaded file size: " + file.length());

        upload.close();

        res.send("Completed!");
      })
      .get("/download", (req, res) -> {
        final URL logo = this.getClass().getClassLoader().getResource(JOOBY_LOGO);
        assert nonNull(logo);
        final File file = new File(logo.toURI());
        log.info("Downloading file with size: " + file.length());

        res.download(file);
      });
  }

  public static void main(String... args) {
    run(UploadDownloadSampleMain::new, args);
  }
}
