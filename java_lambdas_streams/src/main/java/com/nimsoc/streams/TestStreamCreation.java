package com.nimsoc.streams;

import com.nimsoc.objects.Student;
import com.nimsoc.utils.StudentUtil;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class TestStreamCreation {

  private void testCollection() {
    List<Student> createStudents = StudentUtil.createStudents();

    createStudents.stream().forEach(System.out::println);
  }

  private void testEmptyStreams() {
    Stream<Student> studentsEmptyStream = Stream.empty();
    System.out.println("Empty ? :" + studentsEmptyStream.count());
  }

  private void testStreamsFromValues() {
    Stream<String> studentNames = Stream.of("Jim", "Johanna", "Jack", "Joy");
    System.out.println(studentNames.count());
  }

  private void testFileStream() {
    try {
      Stream<String> fileLines = Files.lines(Paths.get("stream.txt"));
      fileLines.forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  
  //infinite
  private void testGenerateIterateStreams() {
    Stream<Double> randomStream = Stream.generate(Math::random);
    //randomStream.forEach(System.out::println);

    Stream<Integer> numbers = Stream.iterate(1, i -> i + 1);
    //numbers.forEach(System.out::println);

  }

  public static void main(String[] args) {
    TestStreamCreation x = new TestStreamCreation();
    
    x.testEmptyStreams();
    x.testStreamsFromValues();
    x.testCollection();
    x.testFileStream();
    
    x.testGenerateIterateStreams();
  }
}
