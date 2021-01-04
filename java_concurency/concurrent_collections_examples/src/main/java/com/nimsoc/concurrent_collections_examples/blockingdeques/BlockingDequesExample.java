package com.nimsoc.concurrent_collections_examples.blockingdeques;

import com.nimsoc.concurrent_collections_examples.Example;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class BlockingDequesExample implements Example {

  @Override
  public void demo() {
    LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>(3);
    
    Client client = new Client(list);
    Thread thread = new Thread(client);
    thread.start();

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 3; j++) {
        String request = null;
        try {
          request = list.take();
        } catch (InterruptedException ex) {
          Logger.getLogger(BlockingDequesExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("BlockingDequesExample: Removed: %s at %s. Size: %d\n", request, new Date(), list.size());
      }
      try {
        TimeUnit.MILLISECONDS.sleep(300);
      } catch (InterruptedException ex) {
        Logger.getLogger(BlockingDequesExample.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    System.out.printf("BlockingDequesExample: End of the program.\n");
  }

}
