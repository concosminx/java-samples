package com.nimsoc.functions;

import com.nimsoc.utils.StudentUtil;
import com.nimsoc.objects.Student;
import java.util.List;
import java.util.function.Predicate;

public class TestPredicates {

  Predicate<Student> aboveFive = (std) -> std.getGrade() > 5;
  Predicate<Student> idStardsWith = std -> std.getStudentId().startsWith("100");
  Predicate<String> stringIsEmpty = s -> s.isEmpty();

  private void testPredicates() {
    //OR
    Predicate<Student> p1 = t -> t.getName().equals("Joe");
    Predicate<Student> p2 = t -> t.getGrade() > 5;
    Predicate<Student> p1OrP2 = p1.or(p2);
    
    //AND
    Predicate<Student> p3 = t -> t.getStudentId().startsWith("2");
    Predicate<Student> p1OrP2AndP3 = p1.or(p2).and(p3);

    //NEGATE
    Predicate<Student> p4 = p3.negate();

    //EQUALS
    List<Student> students = StudentUtil.createStudents();

    Student t1 = new Student("1001", 6, "Joe");

    Predicate<Student> p5 = Predicate.isEqual(t1);
    for (Student st : students) {
      if (p1.test(st)) {
        System.out.println("This is the one: " + st);
      }
    }
  }
  
  public static void main(String[] args) {
    new TestPredicates().testPredicates();
  }
  
}
