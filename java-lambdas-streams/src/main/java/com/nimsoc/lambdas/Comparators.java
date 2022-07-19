package com.nimsoc.lambdas;

import com.nimsoc.objects.LongOperation;
import java.util.Comparator;

public class Comparators {

  private void testComparators(Comparator<LongOperation> cmp) {
    LongOperation zip = new LongOperation("Zip", 234, "Processing");
    LongOperation unzip = new LongOperation("Unzip", 1, "Processing");

    int biggestNoOfFiles = cmp.compare(zip, unzip);

    System.out.println("Big Traded Quantity: " + biggestNoOfFiles);

  }

  public static void main(String[] args) {
    Comparators comp = new Comparators();
    //pre java 1.8
    Comparator<LongOperation> comparator = new Comparator<LongOperation>() {
      @Override
      public int compare(LongOperation op1, LongOperation op2) {
        return op1.getQuantity() > op2.getQuantity() ? op1.getQuantity() : op2.getQuantity();
      }

    };

    comp.testComparators(comparator);
    
    //java 1.8
    comp.testComparators((op1, op2) -> op1.getQuantity() > op2.getQuantity() ? op1.getQuantity() : op2.getQuantity());
  }
}
