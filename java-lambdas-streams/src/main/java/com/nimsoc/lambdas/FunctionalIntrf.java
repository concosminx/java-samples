package com.nimsoc.lambdas;

@FunctionalInterface
public interface FunctionalIntrf {
  
  public void doOneThing();
  
  /*
  not ok; only one method allowed
  public void doAnotherThing();
  */
  
  /*ok if the method is default */
  public default String doADefaultThing() {
    return "Bazinga!";
  }
}
