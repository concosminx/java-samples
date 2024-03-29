package com.nimsoc.concurrent_collections_examples.navigable;

import com.nimsoc.concurrent_collections_examples.Example;
import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class NavigableMapExample implements Example {

  public static void main(String[] args) {
    new NavigableMapExample().demo();
  }

  @Override
  public void demo() {
    ConcurrentSkipListMap<String, Contact> map = new ConcurrentSkipListMap<>();

    Thread threads[] = new Thread[26];
    int counter = 0;

    for (char i = 'A'; i <= 'Z'; i++) {
      Task task = new Task(map, String.valueOf(i));
      threads[counter] = new Thread(task);
      threads[counter].start();
      counter++;
    }

    for (Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException ex) {
        Logger.getLogger(NavigableMapExample.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    System.out.printf("NavigableMapExample: Size of the map: %d\n", map.size());

    Map.Entry<String, Contact> element;
    Contact contact;

    element = map.firstEntry();
    contact = element.getValue();
    System.out.printf("NavigableMapExample: First Entry: %s: %s\n", contact.getName(), contact.getPhone());

    element = map.lastEntry();
    contact = element.getValue();
    System.out.printf("NavigableMapExample: Last Entry: %s: %s\n", contact.getName(), contact.getPhone());

    System.out.printf("NavigableMapExample: Submap from A1996 to B1002: \n");
    ConcurrentNavigableMap<String, Contact> submap = map.subMap("A1996", "B1002");
    do {
      element = submap.pollFirstEntry();
      if (element != null) {
        contact = element.getValue();
        System.out.printf("%s: %s\n", contact.getName(), contact.getPhone());
      }
    } while (element != null);
  }

}
