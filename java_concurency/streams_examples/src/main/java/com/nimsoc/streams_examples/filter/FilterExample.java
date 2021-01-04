package com.nimsoc.streams_examples.filter;

import com.nimsoc.streams_examples.Example;
import com.nimsoc.streams_examples.various.Person;
import com.nimsoc.streams_examples.various.PersonGenerator;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Cosminx
 */
public class FilterExample implements Example {

  @Override
  public void demo() {

    List<Person> persons = PersonGenerator.generatePersonList(10);

    line();
    System.out.printf("Initial list\n");
    persons.parallelStream().forEach(p -> {
      System.out.printf("%s, %s\n", p.getLastName(), p.getFirstName());
    });
    line();
    System.out.printf("\n");

    line();
    System.out.printf("List without duplicates\n");
    persons.parallelStream().distinct().forEach(p -> {
      System.out.printf("%s, %s\n", p.getLastName(), p.getFirstName());
    });
    line();
    System.out.printf("\n");

    line();
    System.out.printf("Array of numbers withoud duplicates\n");
    Integer[] numbers = {6, 7, 6, 5, 6, 7, 8, 9, 6, 7};
    Arrays.asList(numbers).parallelStream().distinct().forEach(n -> {
      System.out.printf("Number %d\n", n);
    });
    line();
    System.out.printf("\n");

    line();
    System.out.printf("Filter with objects\n");
    persons.parallelStream().filter(p -> p.getSalary() < 30000).forEach(p -> {
      System.out.printf("%s, %s\n", p.getLastName(), p.getFirstName());
    });
    line();
    System.out.printf("\n");
    
    
    line();
    System.out.printf("Filter with numbers\n");
    Arrays.asList(numbers).parallelStream().filter(n -> n < 7).forEach(n -> {
      System.out.printf("Number %d\n", n);
    });
    line();
    System.out.printf("\n");
    
    
    line();
    System.out.printf("Limit\n");
    persons.parallelStream().mapToDouble(p -> p.getSalary()).sorted().limit(5).forEach(s -> {
      System.out.printf("Limit %f\n", s);
    });
    line();
    System.out.printf("\n");
    
    
    line();
    System.out.printf("Skip\n");
    persons.parallelStream().mapToDouble(p -> p.getSalary()).sorted().skip(5).forEach(s -> {
      System.out.printf("Skip %f\n", s);
    });
    line();
    System.out.printf("\n");
    
  }

}
