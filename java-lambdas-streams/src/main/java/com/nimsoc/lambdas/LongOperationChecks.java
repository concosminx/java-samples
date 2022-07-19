package com.nimsoc.lambdas;

import com.nimsoc.objects.LongOperation;

public class LongOperationChecks {
  interface LongOperationCheckable<LongOperation> {

    boolean checkOperation(LongOperation t);
  }

  private void testOperation(LongOperation t, ITradable<LongOperation> operation) {
    System.out.println("Operation :" + operation.check(t));
  }

  public static void main(String[] args) throws Exception {
    LongOperationChecks client = new LongOperationChecks();
    LongOperation compileOperation = new LongOperation("Compile project", 1, "Started");

    client.testOperation(compileOperation, (op) -> op.getQuantity() > 2);

    client.testOperation(compileOperation, (op) -> "Started".equals(op.getStatus()));
  }

}
