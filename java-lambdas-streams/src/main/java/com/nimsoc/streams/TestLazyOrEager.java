package com.nimsoc.streams;

import com.nimsoc.objects.Song;
import com.nimsoc.utils.SongUtil;
import java.util.List;
import java.util.stream.Stream;

public class TestLazyOrEager {

  List<Song> songs = SongUtil.createSongs();

  private void testLazy() {
    songs.stream().filter(s -> {
      System.out.println("Lazy here");
      return "Pop".equals(s.getGenre());
    }).count();
  }

  private void testEager() {
    Stream<Song> songsStream
            = songs.stream()
                    .filter(s -> {
                      System.out.println("Filter here");
                      return "Pop".equals(s.getGenre());
                    }).map(s -> {
              System.out.println("Mapping here");
              return s;
            });

    System.out.println("" + songsStream.count());
  }

  public static void main(String[] args) {
    new TestLazyOrEager().testLazy();
    System.out.println("-------");
    new TestLazyOrEager().testEager();
  }
}
