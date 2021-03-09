package com.nimsoc.wordcount;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  public static void setUp() {
    File file = new File("words.txt");
    if (!file.exists()) {
      try (BufferedInputStream in = new BufferedInputStream(new URL("http://www.gutenberg.org/files/4300/4300-0.txt").openStream());
              FileOutputStream fileOutputStream = new FileOutputStream(file)) {
        byte dataBuffer[] = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
          fileOutputStream.write(dataBuffer, 0, bytesRead);
        }
      } catch (IOException e) {
        // handle exception
      }
    }
  }

  public static void main(String args[]) throws IOException, InterruptedException, ExecutionException {
    setUp();
    
    long startTime = System.currentTimeMillis();
    int threads = 4;
    ExecutorService executorService = Executors.newFixedThreadPool(threads);
    final ExecutorCompletionService<Map<String, Long>> completionService = new ExecutorCompletionService<>(executorService);

    List<List<String>> listOfLists = getSplitLists(threads);

    Map<String, Long> allCounts = executeWork(completionService, listOfLists);

    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    System.out.println("Total execution time is " + elapsedTime + " ms");

    executorService.shutdown();
  }

  private static Map<String, Long> executeWork(ExecutorCompletionService<Map<String, Long>> completionService, List<List<String>> listOfLists) throws InterruptedException, ExecutionException {
    listOfLists.forEach(sublist -> completionService.submit(new WordCounter(sublist)));

    Map<String, Long> allCounts = new HashMap<>();
    for (int i = 0; i < listOfLists.size(); i++) {
      Map<String, Long> newCounts = completionService.take().get();
      newCounts.forEach((k, v) -> allCounts.merge(k, v, Long::sum));
    }
    return allCounts;
  }

  private static List<List<String>> getSplitLists(int threads) throws FileNotFoundException {
    String content = new Scanner(new File("words.txt")).useDelimiter("\\Z").next();
    List<String> lines = Arrays.asList(content.split("\n"));

    return splitList(lines, lines.size() / threads);
  }

  private static List<List<String>> splitList(List<String> originalList, int partitionSize) {
    List<List<String>> partitions = new LinkedList<>();
    for (int i = 0; i < originalList.size(); i += partitionSize) {
      partitions.add(originalList.subList(i,
              Math.min(i + partitionSize, originalList.size())));
    }

    return partitions;
  }
}
