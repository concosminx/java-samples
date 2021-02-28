package com.nimsoc.streams;

import com.nimsoc.objects.Song;
import com.nimsoc.objects.Student;
import com.nimsoc.utils.SongUtil;
import com.nimsoc.utils.StudentUtil;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

public class TestCollectors {

  private void collectIntoToCustomCollector() {
    List<Student> students = StudentUtil.createStudents();

    Supplier<StringBuilder> supplier = StringBuilder::new;
    BiConsumer<StringBuilder, Student> accumulator = (sb, student) -> sb.append(student.getName()).append(",");
    BiConsumer<StringBuilder, StringBuilder> combiner = (s1, s2) -> s1.append(s2.toString());
    StringBuilder results = students.stream().collect(supplier, accumulator, combiner);
    System.out.println(results);
  }

  private void stats() {
    List<Student> students = StudentUtil.createStudents();
    IntSummaryStatistics s = students.stream().collect(Collectors.summarizingInt(Student::getGrade));
    System.out.println(s);
  }

  private void collectIntoAList() {
    List<Student> students = StudentUtil.createStudents();
    List<Student> studentCollection = students.stream().collect(toList());

    System.out.println(studentCollection);
  }

  private void collectIntoASet() {
    List<Student> students = StudentUtil.createStudents();
    Set<Student> studentCollection = students.stream().collect(toSet());
    System.out.println(studentCollection);
  }

  private void collectIntoToAMap() {
    List<Song> songs = SongUtil.createSongs();
    Map<String, Song> songMap = songs.stream().collect(toMap(Song::getTitle, song -> song));
    System.out.println(songMap);
  }

  public static void main(String[] args) {
    TestCollectors tc = new TestCollectors();
    tc.collectIntoToCustomCollector();
    tc.stats();
    tc.collectIntoAList();
    tc.collectIntoASet();
    tc.collectIntoToAMap();
  }
}
