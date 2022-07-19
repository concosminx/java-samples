package com.nimsoc.thread_executors_examples.validation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Cosminx
 */
public class UserValidator {
  private final String name;

  public UserValidator(String name) {
    this.name = name;
  }

  /*simulates long running validation process*/
  public boolean validate(String name, String password) {
    Random random = new Random();
    try {
      Long duration = (long) (Math.random() * 10);
      System.out.printf("Validator %s: Validating a user during %d seconds\n", this.name, duration);
      TimeUnit.SECONDS.sleep(duration);
    } catch (InterruptedException e) {
      return false;
    }
    /*random result {true | false} */
    return random.nextBoolean();
  }

  public String getName() {
    return name;
  }
}
