package com.nimsoc.streams_examples.various;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class PersonGenerator {

  public static List<Person> generatePersonList(int size) {
    List<Person> ret = new ArrayList<>();

    String firstNames[] = {"Jane", "Roxanne", "Summer", "Stephanie", "Anika", "James", "Tina", "Robert", "Michael", "Scarlett"};
    String lastNames[] = {"Smith", "Jones", "Lowery", "Williams", "Brown", "Davies", "Davies", "Wilson", "Mccormick", "Roberts"};

    Random randomGenerator = new Random();
    for (int i = 0; i < size; i++) {
      Person person = new Person();
      person.setId(i);
      person.setFirstName(firstNames[randomGenerator.nextInt(10)]);
      person.setLastName(lastNames[randomGenerator.nextInt(10)]);
      person.setSalary(randomGenerator.nextInt(100000));
      person.setCoeficient(randomGenerator.nextDouble() * 10);
      Calendar calendar = Calendar.getInstance();
      calendar.add(Calendar.YEAR, -randomGenerator.nextInt(30));
      Date birthDate = calendar.getTime();
      person.setBirthDate(birthDate);

      ret.add(person);
    }

    return ret;
  }
}
