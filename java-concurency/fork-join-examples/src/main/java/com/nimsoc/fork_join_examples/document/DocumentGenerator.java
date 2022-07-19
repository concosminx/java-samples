package com.nimsoc.fork_join_examples.document;

import java.util.Random;

public class DocumentGenerator {

  private final String words[] = {"teacher", "hearing", "desk", "strategy", "driver", "percentage", "skill", "homework", "perspective", "customer"};

  public String[][] generateDocument(int numLines, int numWords, String word) {
    int counter = 0;
    String document[][] = new String[numLines][numWords];
    Random random = new Random();

    for (int i = 0; i < numLines; i++) {
      for (int j = 0; j < numWords; j++) {
        int index = random.nextInt(words.length); /*random word from static list*/
        document[i][j] = words[index];
        if (document[i][j].equals(word)) {
          counter++;
        }
      }
    }

    System.out.printf("DocumentGenerator: The word appears %d times in the document.\n", counter); /*testing purposes*/
    return document;
  }

}
