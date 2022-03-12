package com.looqbox.challenge.task;

import com.google.common.flogger.FluentLogger;
import com.looqbox.challenge.service.PokemonService;
import com.looqbox.challenge.service.RestService;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class PokemonUpdateTask implements Callable<CompletableFuture<Void>> {

  private final PokemonService service;
  private final RestService restService;

  @Override
  public CompletableFuture<Void> call() {
    return CompletableFuture.runAsync(() -> {
      final var logger = FluentLogger.forEnclosingClass();

      final long start = System.currentTimeMillis();
      service.update(restService.getAll());
      final long end = System.currentTimeMillis();

      logger.atInfo()
          .log("Took %s ms to update the Pokemon Registry via PokeAPI.", String.valueOf(end - start));
    });
  }

}
