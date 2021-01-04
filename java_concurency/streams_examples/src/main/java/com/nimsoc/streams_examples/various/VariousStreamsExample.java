package com.nimsoc.streams_examples.various;

import com.nimsoc.streams_examples.Example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;


/**
 *
 * @author Cosminx
 */
public class VariousStreamsExample implements Example {

  @Override
  public void demo() {
    
    line();
    System.out.printf("Collection stream:\n");
    List<Person> persons = PersonGenerator.generatePersonList(85);
    Stream<Person> personStream = persons.parallelStream();
    System.out.printf("Count method on collection stream: %d\n", personStream.count());
    line();
    System.out.printf("\n");

    line();
    System.out.printf("Supplier stream:\n");
    Supplier<String> supplier = new StringSupplier();
    Stream<String> generatorStream = Stream.generate(supplier);
    generatorStream.parallel().limit(10).forEach(s -> System.out.printf("%s\n", s));
    line();
    System.out.printf("\n");

    line();
    System.out.printf("From a predefined set of elements:\n");
    Stream<String> elementsStream = Stream.of("Bogus", "Hocus", "Lotus");
    elementsStream.parallel().forEach(element -> System.out.printf("%s\n", element));
    line();
    System.out.printf("\n");

    line();
    System.out.printf("From a File:\n");
    /*file from https://archive.ics.uci.edu/ml/machine-learning-databases/car/ */
    try (BufferedReader br = new BufferedReader(new FileReader("data\\car.data"));) {
      Stream<String> fileLines = br.lines();
      System.out.printf("Number of lines in the file: %d\n\n", fileLines.parallel().count());
      line();
      System.out.printf("\n");
      br.close();
    } catch (IOException exception) {
      Logger.getLogger(VariousStreamsExample.class.getName()).log(Level.SEVERE, null, exception);
    }

    line();
    System.out.printf("From a Directory:\n");
    try {
      try (Stream<Path> directoryContent = Files.list(Paths.get(System.getProperty("user.home")))) {
        System.out.printf("Number of elements (files and folders):%d\n\n", directoryContent.parallel().count());
      }
      line();
      System.out.printf("\n");
    } catch (IOException e) {
      Logger.getLogger(VariousStreamsExample.class.getName()).log(Level.SEVERE, null, e);
    }

    line();
    System.out.printf("From an Array:\n");
    String array[] = {"1", "2", "3", "4", "5"};
    Stream<String> streamFromArray = Arrays.stream(array);
    streamFromArray.parallel().forEach(s -> System.out.printf("%s : ", s));
    System.out.printf("\n");
    line();
    System.out.printf("\n");

    
    line();
    System.out.printf("Random number generators:\n");
    Random random = new Random();
    DoubleStream doubleStream = random.doubles(10);
    double doubleStreamAverage = doubleStream.parallel().peek(d -> System.out.printf("%f : ", d)).average().getAsDouble();
    System.out.printf("\nDouble Stream Average: %f\n", doubleStreamAverage);
    line();
    System.out.printf("\n");

    line();
    System.out.printf("Concatenating streams:\n");
    Stream<String> stream1 = Stream.of("1", "2", "3", "4");
    Stream<String> stream2 = Stream.of("5", "6", "7", "8");
    Stream<String> finalStream = Stream.concat(stream1, stream2);
    finalStream.parallel().forEach(s -> System.out.printf("%s : ", s));
    System.out.printf("\n");
    line();
    System.out.printf("\n");
  }

 

}
