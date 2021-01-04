package com.nimsoc.fork_join_examples;

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
