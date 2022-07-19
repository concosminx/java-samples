package com.nimsoc.lambdas.references;

public class ConstructorReferences {

  interface IntArray {

    int[] create(int size);
  }

  private void constructorReferences() {
    IntArray ii1 = (size) -> new int[size];
    IntArray ii2 = int[]::new;
  }

  class Song {

    Song(int trackNo) {
    }

    Song(int trackNo, String name) {
    }
  }

  interface MusicFactory {

    public Song create(int id);
  }

  MusicFactory mf1 = trackNo -> new Song(trackNo);
  MusicFactory mf2 = Song::new;

  interface MusicFactory2 {

    public Song create(int id, String s);
  }
  MusicFactory2 mf3 = Song::new;

  void test() {
    mf1.create(2);
    mf2.create(3);
    mf3.create(9, "Halo");
  }
}
