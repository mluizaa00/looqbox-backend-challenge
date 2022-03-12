package com.looqbox.challenge.exception;

public final class PokemonGetException extends RuntimeException {

  public PokemonGetException(final String message) {
    super(message);
  }

  public PokemonGetException(final String message, final Throwable cause) {
    super(message, cause);
  }

}
