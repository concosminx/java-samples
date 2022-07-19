package com.nimsoc.functions;

import com.nimsoc.objects.Student;
import java.util.function.BiConsumer;

public class TestBiConsummer {

  BiConsumer<Student, Integer> empBonusConsumer
          = (std, grade) -> System.out.printf("Student %s wants a %d grade:", std, grade);

  private void testBiConsumer(Student emp, Integer bonus) {
    empBonusConsumer.accept(emp, bonus);
  }

  public static void main(String[] args) {
    Student s = new Student("100", 7, "Mike");
    int grade = 9;
    new TestBiConsummer().testBiConsumer(s, grade);
  }
}
