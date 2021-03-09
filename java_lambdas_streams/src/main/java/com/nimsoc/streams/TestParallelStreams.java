package com.nimsoc.streams;

import com.nimsoc.objects.Student;
import com.nimsoc.utils.StudentUtil;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TestParallelStreams {

  List<Student> students = StudentUtil.createStudents();

  private void serialStream() {
    Optional<Integer> sumOfStudents = students
            .stream()
            .filter(t -> {
              System.out.printf("Id: %s Filter Thread: %s:\n", t.getStudentId(),
                      Thread.currentThread().getName());
              return t.isOlympic();
            })
            .map(t -> {
              System.out.printf("Id: %s Map Thread: %s:\n", t.getStudentId(),
                      Thread.currentThread().getName());
              return t.getGrade();
            }).reduce(Integer::sum);
    System.out.println(sumOfStudents.get());
  }

  private void parallelStream() {
    Optional<Integer> sumOfStudents = students
            .stream()
            .parallel()
            .filter(Student::isOlympic)
            .peek(t -> System.out.printf(
            "Student Id=%s (Filter Thread Name=%s)\n", t.getStudentId(),
            Thread.currentThread().getName()))
            .map(t -> t.getGrade())
            .peek(t -> System.out.printf("(Mapper Thread Name=%s)\n",
            Thread.currentThread().getName())).reduce(Integer::sum);

    System.out.println(sumOfStudents.get());
  }

  private void collectionParallelStream() {

    Stream<Student> parallelStreams = students.parallelStream();

  }

  public static void main(String[] args) {
    // new ParallelStreams().serialStream();
    new TestParallelStreams().parallelStream();
  }
}
