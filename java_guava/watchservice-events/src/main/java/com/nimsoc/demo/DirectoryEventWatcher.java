package com.nimsoc.demo;

import java.io.IOException;

public interface DirectoryEventWatcher {

  void start() throws IOException;

  boolean isRunning();

  void stop();
}
