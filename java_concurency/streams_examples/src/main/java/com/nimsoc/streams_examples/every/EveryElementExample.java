package com.nimsoc.streams_examples.every;

import com.nimsoc.streams_examples.Example;
import com.nimsoc.streams_examples.reducing.DoubleGenerator;
import com.nimsoc.streams_examples.various.Person;
import com.nimsoc.streams_examples.various.PersonGenerator;
import java.util.List;

/**
 *
 * @author Cosminx
 */
public class EveryElementExample implements Example {

  @Override
  public void demo() {
    List<Person> persons = PersonGenerator.generatePersonList(10);

    line();
    System.out.printf("Parallel forEach()\n");
    persons.parallelStream().forEach(p -> {
      System.out.printf("%s, %s\n", p.getLastName(), p.getFirstName());
    });
    line();
    System.out.printf("\n");

    List<Double> doubles = DoubleGenerator.generateDoubleList(10, 100);

    line();
    System.out.printf("Parallel forEachOrdered() with numbers\n");
    doubles.parallelStream().sorted().forEachOrdered(n -> {
      System.out.printf("%f\n", n);
    });
    line();
    System.out.printf("\n");

    line();
    System.out.printf("Parallel forEach() after sorted() with numbers\n");
    doubles.parallelStream().sorted().forEach(n -> {
      System.out.printf("%f\n", n);
    });
    line();
    System.out.printf("\n");

    line();
    System.out.printf("Parallel forEachOrdered with Persons\n");
    persons.parallelStream().sorted().forEachOrdered(p -> {
      System.out.printf("%s, %s\n", p.getLastName(), p.getFirstName());
    });
    line();
    System.out.printf("\n");

    line();
    System.out.printf("Peek\n");
    doubles.parallelStream()
           .peek(d -> System.out.printf("Step 1: Number: %f\n", d))
           .filter(n -> n < 50)
           .peek(d -> System.out.printf("Step 2: Number: %f\n", d))
           .forEach(d -> System.out.printf("Final Step: Number: %f\n", d));
    
    line();
  }

 

}
