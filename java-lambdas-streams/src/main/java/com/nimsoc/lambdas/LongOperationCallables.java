package com.nimsoc.lambdas;

import com.nimsoc.objects.LongOperation;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LongOperationCallables {

  private void testOperation(Callable<LongOperation> callable) throws Exception {
    ExecutorService es = Executors.newSingleThreadExecutor();
    Future<LongOperation> tradeFuture = es.submit(callable);
    LongOperation t = tradeFuture.get(); //waits
    System.out.println("TestOperation result is: " + t);
    es.shutdown();
  }

  public static void main(String[] args) throws Exception {
    LongOperationCallables client = new LongOperationCallables();

    Callable<LongOperation> c = () -> {
      LongOperation t = new LongOperation("Encrypt files", 2000, "Init");
      System.out.println("...");
      return t;
    };
    client.testOperation(c);

    Callable<LongOperation> callable = () -> new LongOperation("Decrypt files", 2000, "Init");

    LongOperation trade1 = new LongOperation("Upload files", 2000, "Pending");
    LongOperation trade2 = new LongOperation("Upload files", 8000, "Pending");

    client.testOperation(() -> {
      LongOperation op = new LongOperation();
      op.setName(trade1.getName());
      op.setStatus(trade1.getStatus());
      op.setQuantity(trade1.getQuantity() + trade2.getQuantity());
      return op;
    });

  }
}
