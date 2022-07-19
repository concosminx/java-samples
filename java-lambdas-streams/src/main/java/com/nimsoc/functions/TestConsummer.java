package com.nimsoc.functions;

import com.nimsoc.objects.Artist;
import com.nimsoc.objects.Song;
import java.util.function.Consumer;

public class TestConsummer {

  Consumer<Song> printInfo = s -> System.out.println("Printing info: " + s);

  Consumer<Song> persistSong = s -> listen(s);

  Consumer<Song> notifySong = s -> notify(s);

  private void testConsumer(Song s) {
    printInfo.accept(s);
    persistSong.accept(s);
  }

  private void notify(Song m) {
    System.out.println("Notifying about new song " + m);
  }

  public void testAndThen(Song song) {
    Consumer<Song> printAndPersistSong = persistSong.andThen(printInfo);
    printAndPersistSong.accept(song);

    Consumer<Song> chainedConsumer = notifySong.andThen(persistSong).andThen(printInfo);
    chainedConsumer.accept(song);
  }

  private void listen(Song m) {
    System.out.println("Listen to " + m);
  }

  public static void main(String[] args) {
    Song s = new Song(1, "Uptown Funk", "Funk");
    s.addArtist(new Artist("Bruno Mars"));
    s.addArtist(new Artist("Mark Ronson"));
    
    new TestConsummer().testConsumer(s);
    System.out.println("---------");
    new TestConsummer().testAndThen(s);
  }

}
