package com.nimsoc.streams_examples.sorting;

import com.nimsoc.streams_examples.Example;
import com.nimsoc.streams_examples.various.Person;
import com.nimsoc.streams_examples.various.PersonGenerator;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author Cosminx
 */
public class SortingExample implements Example {

  @Override
  public void demo() {

    int[] numbers = {9, 8, 7, 6, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    line();
    Arrays.stream(numbers).parallel().sorted().forEachOrdered(n -> {
      System.out.printf("%d\n", n);
    });
    line();
    System.out.printf("\n");

    line();
    List<Person> persons = PersonGenerator.generatePersonList(10);
    persons.parallelStream().sorted().forEachOrdered(p -> {
      System.out.printf("%s, %s\n", p.getLastName(), p.getFirstName());
    });
    line();
    System.out.printf("\n");

    line();
    Person person = persons.get(0);
    System.out.printf("%s %s\n", person.getFirstName(), person.getLastName());

    TreeSet<Person> personSet = new TreeSet<>(persons);
    for (int i = 0; i < 10; i++) {
      System.out.printf("********** %d ***********\n", i);
      person = personSet.stream().parallel().limit(1).collect(Collectors.toList()).get(0);
      System.out.printf("%s %s\n", person.getFirstName(), person.getLastName());

      person = personSet.stream().unordered().parallel().limit(1).collect(Collectors.toList()).get(0);
      System.out.printf("%s %s\n", person.getFirstName(), person.getLastName());
      System.out.printf("*************************\n", i);
    }

  }
}
