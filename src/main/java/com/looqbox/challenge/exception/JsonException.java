package com.looqbox.challenge.exception;

public final class JsonException extends RuntimeException {

  public JsonException() {
  }

  public JsonException(final String message) {
    super(message);
  }

  public JsonException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public JsonException(final Throwable cause) {
    super(cause);
  }

}
