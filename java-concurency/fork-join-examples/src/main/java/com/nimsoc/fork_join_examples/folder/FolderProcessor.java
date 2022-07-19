package com.nimsoc.fork_join_examples.folder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountedCompleter;

/**
 *
 * @author Cosminx
 */
public class FolderProcessor extends CountedCompleter<List<String>> {

  private final String path;

  private final String extension;

  private List<FolderProcessor> tasks;
  private List<String> resultList;

  protected FolderProcessor(CountedCompleter<?> completer, String path, String extension) {
    super(completer);
    this.path = path;
    this.extension = extension;
  }

  public FolderProcessor(String path, String extension) {
    this.path = path;
    this.extension = extension;
  }

  @Override
  public void compute() {

    resultList = new ArrayList<>();
    tasks = new ArrayList<>();

    File file = new File(path);
    File content[] = file.listFiles();

    if (content != null) {
      for (File content1 : content) {
        if (content1.isDirectory()) {
          /*for directory fork a new task*/
          FolderProcessor task = new FolderProcessor(this, content1.getAbsolutePath(), extension);
          task.fork();
          addToPendingCount(1);
          tasks.add(task);
        } else {
          /*check the file - by extension*/
          if (checkFile(content1.getName())) {
            resultList.add(content1.getAbsolutePath());
            System.out.printf("Result found: %s\n", content1.getAbsolutePath());
          }
        }
      }
      /*write a message for more than 50 tasks */
      if (tasks.size() > 50) {
        System.out.printf("%s: %d tasks ran.\n", file.getAbsolutePath(), tasks.size());
      }
    }
    
    /*if the pending count is nonzero, decrements the count; otherwise invokes onCompletion(CountedCompleter) */
    tryComplete();
  }

  @Override
  public void onCompletion(CountedCompleter<?> completer) {
    for (FolderProcessor childTask : tasks) {
      resultList.addAll(childTask.getResultList());
    }
  }

  private boolean checkFile(String name) {
    if (name.endsWith(extension)) {
      return true;
    }
    return false;
  }

  public List<String> getResultList() {
    return resultList;
  }
}
