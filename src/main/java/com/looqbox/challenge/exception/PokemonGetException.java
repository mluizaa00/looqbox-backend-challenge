package com.looqbox.challenge.exception;

public class PokemonGetException extends RuntimeException {

  public PokemonGetException() {
  }

  public PokemonGetException(final String message) {
    super(message);
  }

  public PokemonGetException(final String message, final Throwable cause) {
    super(message, cause);
  }

}
