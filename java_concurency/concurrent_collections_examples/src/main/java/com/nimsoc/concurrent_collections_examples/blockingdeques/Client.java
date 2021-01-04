package com.nimsoc.concurrent_collections_examples.blockingdeques;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client implements Runnable {

  private final LinkedBlockingDeque<String> requestList;

  public Client(LinkedBlockingDeque<String> requestList) {
    this.requestList = requestList;
  }

  @Override
  public void run() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 5; j++) {
        StringBuilder request = new StringBuilder();
        request.append(i);
        request.append(":");
        request.append(j);

        try {
          requestList.put(request.toString());
        } catch (InterruptedException ex) {
          Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.printf("Client added: %s at %s.\n", request, new Date());
      }

      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException ex) {
        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
      }

    }
    System.out.printf("Client: End.\n");
  }

}
