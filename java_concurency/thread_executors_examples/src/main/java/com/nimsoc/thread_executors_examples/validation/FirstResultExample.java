package com.nimsoc.thread_executors_examples.validation;

import com.nimsoc.thread_executors_examples.Example;
import com.nimsoc.thread_executors_examples.Main;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class FirstResultExample implements Example {

  @Override
  public void demo() {
    String username = "test";
    String password = "test";

    /*2 validators - LDAP | DB */
    UserValidator ldapValidator = new UserValidator("LDAP");
    UserValidator dbValidator = new UserValidator("DataBase");

    ValidatorTask ldapTask = new ValidatorTask(ldapValidator, username, password);
    ValidatorTask dbTask = new ValidatorTask(dbValidator, username, password);

    List<ValidatorTask> taskList = Arrays.asList(ldapTask, dbTask);

    ExecutorService executor = (ExecutorService) Executors.newCachedThreadPool();
    String result = "";

    try {
      /*
      Executes the given tasks, returning the result of one that has completed successfully (i.e., without throwing an exception),
      if any do. Upon normal or exceptional return, tasks that have not completed are cancelled. The results of this method are
      undefined if the given collection is modified while this operation is in progress.
       */
      result = executor.invokeAny(taskList);
    } catch (InterruptedException | ExecutionException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.printf("FirstResultExample ->Result: %s\n", result);

    executor.shutdown();
    System.out.printf("FirstResultExample ->End of the Execution\n");
  }

}
