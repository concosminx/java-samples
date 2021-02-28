package com.nimsoc.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Song {
  
  private final int trackNo; 
  private final String title; 
  private final String genre;
  private final List<Artist> artists = new ArrayList<>();

  public Song(int trackNo, String title, String genre) {
    this.trackNo = trackNo;
    this.title = title;
    this.genre = genre;
  }
  
  

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 59 * hash + Objects.hashCode(this.title);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Song other = (Song) obj;
    if (!Objects.equals(this.title, other.title)) {
      return false;
    }
    return true;
  }

  public int getTrackNo() {
    return trackNo;
  }

  public String getTitle() {
    return title;
  }

  public String getGenre() {
    return genre;
  }

  public List<Artist> getArtists() {
    return artists;
  }
  
  public void addArtist(Artist a) {
    this.getArtists().add(a);
  }

  @Override
  public String toString() {
    return "Song{" + "trackNo=" + trackNo + ", title=" + title + ", genre=" + genre + ", artists=" + artists + '}';
  }
  
}
