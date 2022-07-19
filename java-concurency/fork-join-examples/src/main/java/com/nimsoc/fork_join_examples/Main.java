package com.nimsoc.fork_join_examples;

import com.nimsoc.fork_join_examples.cancel.CancelTaskExample;
import com.nimsoc.fork_join_examples.exception.ThrowExceptionTaskExample;
import com.nimsoc.fork_join_examples.document.DocumentProcessingExample;
import com.nimsoc.fork_join_examples.folder.FolderScanExample;
import com.nimsoc.fork_join_examples.productprice.ProductPriceUpdateExample;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Cosminx
 */
public class Main {

  public static void main(String[] args) {
    
    List<Example> exp = Arrays.asList(
            /*fork join pool*/
            new ProductPriceUpdateExample(),
            /*join tasks results*/
            new DocumentProcessingExample(),
            /* running tasks asynchronously */
            new FolderScanExample(),
            /*canceling a task*/
            new CancelTaskExample(),
            /*throwing exceptions*/
            new ThrowExceptionTaskExample()
    );

    exp.forEach((x) -> {
      x.demo();
    });

  }
}
