package com.looqbox.challenge.exception;

public class RestException extends RuntimeException {

  public RestException() {
  }

  public RestException(final String message) {
    super(message);
  }

  public RestException(final String message, final Throwable cause) {
    super(message, cause);
  }

}
