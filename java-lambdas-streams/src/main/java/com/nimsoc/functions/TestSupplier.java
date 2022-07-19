package com.nimsoc.functions;

import com.nimsoc.objects.Student;
import com.nimsoc.utils.StudentUtil;
import java.util.List;
import java.util.function.Supplier;

public class TestSupplier {

  Supplier<String[]> beerSupplier = () -> new String[]{"Heineken", "Becks", "Primator"};

  Supplier<List<Student>> studentSupplier = () -> StudentUtil.createStudents();

  private void testSupplier() {
    String[] beers = beerSupplier.get();
    for (String beer : beers) {
      System.out.println("I want: " + beer);
    }

    List<Student> students = studentSupplier.get();
    for (Student std : students) {
      System.out.println("Student is: " + std);
    }
  }

  public static void main(String[] args) {
    new TestSupplier().testSupplier();
  }
}
