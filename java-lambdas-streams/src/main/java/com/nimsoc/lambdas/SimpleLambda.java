package com.nimsoc.lambdas;

public class SimpleLambda {

  interface SimpleGreeting {

    public String sayHi(String g);
  }

  private void testSimpleGreeting(String a, SimpleGreeting g) {
    String result = g.sayHi(a);
    System.out.println("Greeting: " + result);
  }

  public static void main(String[] args) {
    //pre java 1.8
    new SimpleLambda().testSimpleGreeting("Jane", new SimpleGreeting() {
      @Override
      public String sayHi(String g) {
        return "Hi, " + g;
      }
    });

    new SimpleLambda().testSimpleGreeting("John", (String s) -> "Hello, " + s);

    new SimpleLambda().testSimpleGreeting("",
            (String p) -> !p.isEmpty() ? ("Salve, " + p) : " You forgot something ??");
  }

}
