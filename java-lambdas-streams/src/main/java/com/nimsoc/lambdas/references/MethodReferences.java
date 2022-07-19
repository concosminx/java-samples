package com.nimsoc.lambdas.references;

public class MethodReferences {

  public void testMovieStaticMethodRef() {
    ISong s1 = (i) -> i < 100;
    ISong s2 = MethodReferences::isClassic;
  }

  private void testMovieInstanceMethodRef() {
    MethodReferences ref = new MethodReferences();
    ISong s1 = (i) -> i > 10 && i < 100;
    ISong s2 = ref::isTopMostWanted;
  }

  private void testMovieArbitaryObjectMethod() {
    ISong m1 = ArbitraryClass::isRock;
  }

  public boolean isTopMostWanted(int trackNo) {
    return true;
  }

  public static boolean isClassic(int trackNo) {
    return true;
  }

  public static void main(String[] args) {
    MethodReferences client = new MethodReferences();
  }

}

class ArbitraryClass {

  public static boolean isRock(int i) {
    return false;
  }
}

interface ISong {

  public boolean check(int id);
}
