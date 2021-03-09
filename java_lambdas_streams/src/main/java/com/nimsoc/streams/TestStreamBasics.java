package com.nimsoc.streams;

import com.nimsoc.objects.Song;
import com.nimsoc.objects.Student;
import com.nimsoc.utils.SongUtil;
import com.nimsoc.utils.StudentUtil;
import java.util.ArrayList;
import java.util.List;

public class TestStreamBasics {

  private List<Student> findGoodStudentsUsingPreJava8(List<Student> students) {
    List<Student> goodStudents = new ArrayList<>();
    for (Student student : students) {
      if (student.getGrade() > 6) {
        goodStudents.add(student);
      }
    }

    return goodStudents;
  }

  private void findGoodStudentsUsingStreams(List<Student> students) {

    students.parallelStream()
            .filter(s -> s.getGrade() > 6)
            .limit(10)
            .distinct()
            .forEach(System.out::println);
  }

  private void findSongsByGenre() {
    List<Song> createSongs = SongUtil.createSongs();

    createSongs.stream()
            .filter(s -> s.getGenre().equals("Soft rock"))
            .map(Song::getTitle)
            .distinct()
            .limit(3)
            .forEach(System.out::println);
  }

  public static void main(String[] args) {
    TestStreamBasics basics = new TestStreamBasics();
    List<Student> students = StudentUtil.createStudents();

    List<Student> findGoodStudentsUsingPreJava8 = basics.findGoodStudentsUsingPreJava8(students);
    findGoodStudentsUsingPreJava8.stream().forEach(System.out::println);
    System.out.println("------------");
    basics.findGoodStudentsUsingStreams(students);
    System.out.println("------------");
    basics.findSongsByGenre();
  }

}
