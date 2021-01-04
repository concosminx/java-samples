package com.nimsoc.concurrent_collections_examples;

/**
 *
 * @author Cosminx
 */
public interface Example {

  public void demo();

  default public void line() {
    System.out.printf("---------------------------------------------------\n");
  }
}
