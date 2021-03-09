package com.nimsoc.utils;

import com.nimsoc.objects.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentUtil {

  public static List<Student> createStudents() {
    List<Student> students = new ArrayList<>();
    students.add(new Student("1001", 6, "Joe"));
    students.add(new Student("1002", 9, "Jane"));
    students.add(new Student("1003", 4, "Jim"));
    students.add(new Student("1004", 7, "John"));
    students.add(new Student("1005", 7, "Remy"));
    students.add(new Student("2000", 5, "Jack"));
    students.add(new Student("2001", 8, "Joy"));
    Student s = new Student("2002", 10, "July");
    s.setOlympic(true);
    students.add(s);
    s = new Student("2003", 10, "Julie");
    s.setOlympic(true);
    students.add(s);
    return students;
  }

  public static List<Student> createStudents(int size) {
    List<Student> students = new ArrayList<>();
    Random r = new Random();
    for (int i = 0; i < size; i++) {
      students.add(new Student("" + i + 1000, 1 + r.nextInt(9), i % 2 == 0 ? "Jane" + i : "John" + i));
    }
    return students;
  }

}
