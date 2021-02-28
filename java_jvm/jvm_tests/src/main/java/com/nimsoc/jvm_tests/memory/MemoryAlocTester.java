package com.nimsoc.jvm_tests.memory;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class MemoryAlocTester {

  public static void main(String[] args) throws Exception {

    TimeUnit.SECONDS.sleep(20);
    System.out.println("Alocate on Heap");
    byte[] bytes = new byte[256 * 1000 * 1000];
    bytes[0] = 1;
    bytes[1] = 2;

    TimeUnit.SECONDS.sleep(10);
    System.out.println("Alocate with ByteBuffer");
    ByteBuffer buffer = ByteBuffer.allocateDirect(256 * 1024 * 1024);
    buffer.put(bytes);
    buffer.flip();

    TimeUnit.SECONDS.sleep(10);
    System.out.println("GC - 1 - Cleanup Heap");
    bytes = null;
    System.gc();

    TimeUnit.SECONDS.sleep(10);
    System.out.println("Get bytes from ByteBuffer");
    byte[] resultbytes = new byte[256 * 1000 * 1000];
    buffer.get(resultbytes);
    System.out.println("Resultbytes[1]: " + resultbytes[1]);

    TimeUnit.SECONDS.sleep(10);
    System.out.println("GC - 2 - Cleanup Heap");
    buffer = null;
    resultbytes = null;
    System.gc();

    TimeUnit.SECONDS.sleep(10);
  }
}
