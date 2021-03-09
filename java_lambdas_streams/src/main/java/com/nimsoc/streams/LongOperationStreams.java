package com.nimsoc.streams;

import com.nimsoc.objects.LongOperation;
import java.util.Arrays;
import java.util.List;

public class LongOperationStreams {

  public void testLongOperationStreams() {
    List<LongOperation> trades = Arrays.asList(
            new LongOperation("Run svn update", 7, "In Progress"),
            new LongOperation("Compile", 5, "Finished"),
            new LongOperation("Jar", 10, "Finished"),
            new LongOperation("Publish", 9, "Finished"));

    LongOperation bigTrade = trades.stream()
            .filter(this::getQuantity)
            .filter(t -> t.getStatus().equals("Finished"))
            .findFirst()
            .get();

    System.out.println("The op:" + bigTrade);
  }

  private boolean getQuantity(LongOperation t) {
    return t.getQuantity() > 5;
  }

  public static void main(String[] args) throws Exception {
    LongOperationStreams client = new LongOperationStreams();

    List<Integer> ciphers = Arrays.asList(1, 2, 3, 4, 5);
    ciphers.forEach(e -> System.out.println(e));
    //or 
    ciphers.forEach(System.out::println);

    long count = ciphers.stream()
            .filter(i -> i > 3)
            .count();

    System.out.println("Nr: " + count);

    client.testLongOperationStreams();
  }
}
