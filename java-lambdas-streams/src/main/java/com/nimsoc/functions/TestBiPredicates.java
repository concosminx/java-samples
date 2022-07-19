package com.nimsoc.functions;

import com.nimsoc.objects.Student;
import com.nimsoc.objects.Teacher;
import java.util.function.BiPredicate;

public class TestBiPredicates {

  BiPredicate<Student, Teacher> stdTeacherPredicate = (student, teacher) -> student
          .getTeacher().equals(teacher);

  BiPredicate<Student, Teacher> notAsStdTeacherPredicate = stdTeacherPredicate.negate();

  private void testBiPredicate(Student s, Teacher t) {
    boolean isTeacher = stdTeacherPredicate.test(s, t);
    System.out.println("Is teacher? " + isTeacher);
  }

  public static void main(String[] args) {
    Student s = new Student("1200", 7, "Jim");
    Teacher t = new Teacher("Max");
    s.setTeacher(t);
    
    new TestBiPredicates().testBiPredicate(s, t);

    
  }

}
