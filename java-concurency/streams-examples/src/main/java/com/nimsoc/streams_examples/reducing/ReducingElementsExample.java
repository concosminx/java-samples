package com.nimsoc.streams_examples.reducing;

import com.nimsoc.streams_examples.Example;
import com.nimsoc.streams_examples.various.Person;
import com.nimsoc.streams_examples.various.PersonGenerator;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

/**
 *
 * @author Cosminx
 */
public class ReducingElementsExample implements Example {

  @Override
  public void demo() {

    line();
    System.out.printf("ReducingElementsExample: Examples of reduce methods.\n");

    System.out.printf("ReducingElementsExample: Creating a list of double numbers.\n");
    List<Double> numbers = DoubleGenerator.generateDoubleList(10000, 1000);
    line();
    System.out.printf("\n");

    line();
    DoubleStream doubleStream = DoubleGenerator.generateStreamFromList(numbers);
    long numberOfElements = doubleStream.parallel().count();
    System.out.printf("The list of numbers has %d elements.\n", numberOfElements);
    line();
    System.out.printf("\n");

    line();
    doubleStream = DoubleGenerator.generateStreamFromList(numbers);
    double sum = doubleStream.parallel().sum();
    System.out.printf("Its numbers sum %f.\n", sum);
    line();
    System.out.printf("\n");

    line();
    doubleStream = DoubleGenerator.generateStreamFromList(numbers);
    double average = doubleStream.parallel().average().getAsDouble();
    System.out.printf("Its numbers have an average value of %f.\n", average);
    line();
    System.out.printf("\n");

    line();
    doubleStream = DoubleGenerator.generateStreamFromList(numbers);
    double max = doubleStream.parallel().max().getAsDouble();
    System.out.printf("The maximum value in the list is %f.\n", max);
    line();
    System.out.printf("\n");

    line();
    doubleStream = DoubleGenerator.generateStreamFromList(numbers);
    double min = doubleStream.parallel().min().getAsDouble();
    System.out.printf("The minimum value in the list is %f.\n", min);
    line();
    

    line();
    System.out.printf("Reduce - First Version\n");
    List<Point> points = PointGenerator.generatePointList(10000);
    Optional<Point> point = points.parallelStream().reduce((p1, p2) -> {
      Point p = new Point();
      p.setX(p1.getX() + p2.getX());
      p.setY(p1.getY() + p2.getY());
      return p;
    });
    System.out.println(point.get().getX() + ":" + point.get().getY());
    line();
    System.out.printf("\n");

    line();
    System.out.printf("Reduce, second version\n");
    List<Person> persons = PersonGenerator.generatePersonList(10000);
    long totalSalary = persons.parallelStream().map(p -> p.getSalary()).reduce(0, (s1, s2) -> s1 + s2);
    System.out.printf("Total salary: %d\n", totalSalary);
    line();
    System.out.printf("\n");

    line();
    System.out.printf("Reduce, third version\n");
    Integer value = 0;
    value = persons.parallelStream().reduce(value, (n, p) -> {
      if (p.getSalary() > 50000) {
        return n + 1;
      } else {
        return n;
      }
    }, (n1, n2) -> n1 + n2);
    System.out.printf("The number of people with a salary bigger that 50,000 is %d\n", value);
    line();
    System.out.printf("\n");
  }
  


}
