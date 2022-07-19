package com.nimsoc.lambdas;

public class LongOperationRunnables {

  private void testOperationRunnable(Runnable r) {
    new Thread(r).start();
  }

  public static void main(String[] args) throws Exception {
    LongOperationRunnables client = new LongOperationRunnables();

    client.testOperationRunnable(() -> System.out.println("Uuuuuu a new lambda thread .... !"));

    client.testOperationRunnable(() -> {
      System.out.println("Uuuu a new lambda with thread complex code ... {} ");
      extraComplexStuff();
    });
  }
  
  private static void extraComplexStuff() {
    System.out.println("Extra stuff ... ");
  }

}
