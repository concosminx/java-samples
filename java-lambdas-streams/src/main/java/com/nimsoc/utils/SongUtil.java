package com.nimsoc.utils;

import com.nimsoc.objects.Artist;
import com.nimsoc.objects.Song;
import java.util.ArrayList;
import java.util.List;

public class SongUtil {

  public static List<Song> createSongs() {
    
    List<Song> songs = new ArrayList<>();
    songs.add(new Song(1, "(Everything I Do) I Do It for You", "Soft rock"));
    songs.add(new Song(2, "Gonna Make You Sweat (Everybody Dance Now)", "Dance-pop"));
    songs.add(new Song(3, "Rush Rush", "Pop"));
    songs.add(new Song(4, "One More Try (Timmy T song)", "Pop"));
    songs.add(new Song(5, "Unbelievable (EMF song)", "Mix"));
    songs.add(new Song(6, "More Than Words", "Soft rock"));

    return songs;

  }

  public static List<Song> createSongsAndActors() {
    List<Song> songs = new ArrayList<>();
    Song s = new Song(1, "Good Vibrations", "Pop rap");
    s.addArtist(new Artist("Marky Mark"));
    s.addArtist(new Artist("Funky Bunch"));
    songs.add(s);
    
    s = new Song(2, "Summertime ", "R&B");
    s.addArtist(new Artist("DJ Jazzy Jeff"));
    s.addArtist(new Artist("The Fresh Prince"));
    songs.add(s);

    return songs;

  }

}
