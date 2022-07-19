package com.nimsoc.lambdas.scopes;

public class SuperScope {

  public static void main(String[] args) {
    new SubScope().testMember("SHAZAM");
  }
  
  final String attribute = "THE POSTMAN";

}

class SubScope extends SuperScope {

  private String attribute = "THE GRUMPYMAN";

  interface Family {
    String who(String attribute);
  }

  public void testMember(String attribute) {
    System.out.println("Local member:" + attribute);
    System.out.println("Family member " + this.attribute);
    System.out.println("Family member " + super.attribute);

    Family familyLambda = (familyMember) -> {
      System.out.println("Local lambda member: " + familyMember);
      System.out.println("Local lambda member: " + attribute);
      System.out.println("Local lambda this.member: " + this.attribute);
      System.out.println("Local lambda super.member: " + super.attribute);
      return familyMember;
    };

    familyLambda.who(attribute);
  }

}
