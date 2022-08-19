package com.nimsoc.concurrent_collections_examples.vol;

import com.nimsoc.concurrent_collections_examples.Example;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class VolatileExample implements Example {

  public static void main(String[] args) {
    new VolatileExample().demo();
  }

  @Override
  public void demo() {

    VolatileFlag volatileFlag = new VolatileFlag();
    Flag flag = new Flag();

    VolatileTask vt = new VolatileTask(volatileFlag);
    Task t = new Task(flag);

    Thread thread = new Thread(vt);
    thread.start();
    thread = new Thread(t);
    thread.start();

    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException ex) {
      Logger.getLogger(VolatileExample.class.getName()).log(Level.SEVERE, null, ex);
    }

    System.out.printf("VolatileExample: Going to stop volatile task: %s\n", new Date());
    volatileFlag.flag = false;
    System.out.printf("VolatileExample: Volatile stop flag changed: %s\n", new Date());

    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException ex) {
      Logger.getLogger(VolatileExample.class.getName()).log(Level.SEVERE, null, ex);
    }

    System.out.printf("VolatileExample: Going to stop task: %s\n", new Date());
    flag.flag = false;
    System.out.printf("VolatileExample: Task stoped: %s\n", new Date());

    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException ex) {
      Logger.getLogger(VolatileExample.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

}
