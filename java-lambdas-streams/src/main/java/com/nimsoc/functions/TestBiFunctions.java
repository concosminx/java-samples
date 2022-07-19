package com.nimsoc.functions;

import com.nimsoc.objects.Student;
import com.nimsoc.objects.Teacher;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TestBiFunctions {

  BiFunction<Student, Teacher, Student> studentTeacherBiFunc = (s, t) -> s.getTeacher().getPa().get();
  Function<Student, Student> emplManagerFunction = s -> s.getTeacher().getPa().get();

  private void testBiFunction(Student s, Teacher t) {
    Student s2 = studentTeacherBiFunc.apply(s, t);
    System.out.println("Student" + s2);
  }

  public static void main(String[] args) {

    Student s1 = new Student("1200", 7, "Jim");
    Teacher t = new Teacher("Max");
    s1.setTeacher(t);
    Student s2 = new Student("1100", 9, "Jack");
    t.setPa(Optional.of(s2));

    new TestBiFunctions().testBiFunction(s1, t);
  }
}
