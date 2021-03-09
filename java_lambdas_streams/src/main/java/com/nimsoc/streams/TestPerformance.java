package com.nimsoc.streams;

import com.nimsoc.objects.Student;
import com.nimsoc.utils.StudentUtil;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class TestPerformance {

  public void sumStudentsInSerial() {
    List<Student> students = StudentUtil.createStudents(100);
    Instant start = Instant.now();
    students.stream()
            .map(Student::getGrade)
            .reduce(Integer::sum);
    Instant end = Instant.now();
    Duration d = Duration.between(start, end);
    System.out.printf("%s %d %s", "Aggregating students took ", d.toMillis(), " ms in Seqential mode");
  }

  public void sumStudentsInParallell() {
    List<Student> students = StudentUtil.createStudents(100);
    Instant start = Instant.now();
    students.stream()
            .parallel()
            .map(Student::getGrade)
            .reduce(Integer::sum);

    Instant end = Instant.now();
    Duration d = Duration.between(start, end);
    System.out.printf("%s %d %s", "Aggregating students took ", d.toMillis(), " ms in Parallel mode");
  }

  public static void main(String[] args) {
    new TestPerformance().sumStudentsInSerial();
    System.out.println("---------------");
    new TestPerformance().sumStudentsInParallell();
  }
}
