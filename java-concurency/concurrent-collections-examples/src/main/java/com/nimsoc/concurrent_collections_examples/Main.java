package com.nimsoc.concurrent_collections_examples;

import com.nimsoc.concurrent_collections_examples.atomicarr.AtomicArraysExample;
import com.nimsoc.concurrent_collections_examples.atomicvars.AtomicVarsExample;
import com.nimsoc.concurrent_collections_examples.blockingdeques.BlockingDequesExample;
import com.nimsoc.concurrent_collections_examples.blockingdeques.priority.BlockingDequesPriorityExample;
import com.nimsoc.concurrent_collections_examples.delayed.ListsDelayedElemExample;
import com.nimsoc.concurrent_collections_examples.hash.HashMapExample;
import com.nimsoc.concurrent_collections_examples.navigable.NavigableMapExample;
import com.nimsoc.concurrent_collections_examples.nonbdeques.NonBlockingDequesExample;
import com.nimsoc.concurrent_collections_examples.vol.VolatileExample;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Example> exp = Arrays.asList(/*non-blocking thread-safe deques*/
            //new NonBlockingDequesExample(),
            
            /*blocking thread-safe deques*/
            //new BlockingDequesExample()
            
            /*blocking thread-safe queue ordered by priority*/
            //new BlockingDequesPriorityExample()
            
            /*thread-safe lists with delayed elements*/
            //new ListsDelayedElemExample()
    
            /*thread-safe navigable maps*/
            //new NavigableMapExample()
    
            /*thread-safe hashmaps*/
            //new HashMapExample()
    
            /*atomic variables*/
            //new AtomicVarsExample()
    
            /*atomic arrays*/
            //new AtomicArraysExample()
            
            /*volatile keyword*/
            //new VolatileExample()
            

    );
    
    
    exp.forEach((x) -> {
      x.demo();
    });

  }

}
