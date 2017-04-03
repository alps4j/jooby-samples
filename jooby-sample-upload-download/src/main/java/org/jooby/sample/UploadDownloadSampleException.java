package org.jooby.sample;

public final class UploadDownloadSampleException extends RuntimeException {
  public UploadDownloadSampleException() {
  }

  public UploadDownloadSampleException(String message) {
    super(message);
  }

  public UploadDownloadSampleException(String message, Throwable cause) {
    super(message, cause);
  }

  public UploadDownloadSampleException(Throwable cause) {
    super(cause);
  }

  public UploadDownloadSampleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
