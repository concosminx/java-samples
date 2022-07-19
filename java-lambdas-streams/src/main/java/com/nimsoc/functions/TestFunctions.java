package com.nimsoc.functions;

import com.nimsoc.objects.Song;
import com.nimsoc.objects.Student;
import com.nimsoc.objects.Teacher;
import com.nimsoc.utils.StudentUtil;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestFunctions {

  List<Student> students = StudentUtil.createStudents();
  Supplier<List<Student>> studentsSupplier = () -> StudentUtil.createStudents();

  Function<String, Song> createSongFunction = s -> new Song(1, s, "Mix");

  Function<String, Student> studentFinder = id -> {
    for (Student student : students) {
      if (student.getStudentId().equals(id)) {
        return student;
      }
    }
    return new Student("", 0, "");
  };

  Function<String, Student> studentFinder2 = id -> {
    List<Student> trades = studentsSupplier.get();
    return trades.stream()
            .filter(s -> s.getStudentId().equals(id))
            .findFirst()
            .get();
  };

  private void testFunction(String songName) {
    Song movie = createSongFunction.apply(songName);
    System.out.println("Song is: " + movie);

    Student s = studentFinder.apply("1004");
    System.out.println("Student: " + s);
  }

  public static void main(String[] args) {
    new TestFunctions().testFunction("Rush Rush");
  }

  Function<Student, Teacher> teacherFinder = (student) -> student.getTeacher();
  Function<Teacher, Student> paFinder = (teacher) -> teacher.getPa().get();

  private void testAndThen(Student student) {
    Function<Student, Student> studentTeacherAssistantFinder = teacherFinder.andThen(paFinder);
  }

  private void testCompose(Student student) {
    Function<Student, Student> stdFinder = paFinder.compose(teacherFinder);
  }
}
