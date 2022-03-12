package com.looqbox.challenge;

import com.looqbox.challenge.service.PokemonService;
import com.looqbox.challenge.service.RestService;
import com.looqbox.challenge.task.PokemonUpdateTask;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

// @EnableCaching
@SpringBootApplication
public class ChallengeApplication {

  @Autowired
  private PokemonService service;

  @Autowired
  private RestService restService;

  public static void main(final String[] args) {
    SpringApplication.run(ChallengeApplication.class, args);
  }

  /**
   * The init method is only initialized after
   * the application is ready via a {@link EventListener}
   *
   * A {@link PokemonUpdateTask} is created and the called.
   */
  @Async
  @EventListener(ApplicationReadyEvent.class)
  public void init() {
    final var updateTask = new PokemonUpdateTask(service, restService);
    CompletableFuture.runAsync(updateTask);
  }

}
