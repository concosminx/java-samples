package com.nimsoc.thread_executors_examples.rejected;

import com.nimsoc.thread_executors_examples.Example;

/**
 *
 * @author Cosminx
 */
public class RejectedTaskExample implements Example {

  @Override
  public void demo() {
    Server server = new Server();
    System.out.printf("RejectedTaskExample -> Starting.\n");
    /*send 50 tasks to server*/
    for (int i = 0; i < 50; i++) {
      RejectedTask task = new RejectedTask("Task " + i);
      server.executeTask(task);
    }
    System.out.printf("RejectedTaskExample -> Shuting down the Executor.\n");
    /*shutting down the server */
    server.endServer();
    System.out.printf("RejectedTaskExample -> Sending another Task.\n");

    RejectedTask task = new RejectedTask("Rejected task");
    server.executeTask(task);
    System.out.printf("RejectedTaskExample -> End.\n");
  }

}
