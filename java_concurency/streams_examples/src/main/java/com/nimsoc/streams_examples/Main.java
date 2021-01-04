package com.nimsoc.streams_examples;

import com.nimsoc.streams_examples.collector.CollectorExample;
import com.nimsoc.streams_examples.conditions.ConditionsExample;
import com.nimsoc.streams_examples.every.EveryElementExample;
import com.nimsoc.streams_examples.filter.FilterExample;
import com.nimsoc.streams_examples.reactive.ReactiveExample;
import com.nimsoc.streams_examples.reducing.ReducingElementsExample;
import com.nimsoc.streams_examples.sorting.SortingExample;
import com.nimsoc.streams_examples.transforming.TransformingExample;
import com.nimsoc.streams_examples.various.VariousStreamsExample;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Cosminx
 */
public class Main {

  public static void main(String[] args) {
    List<Example> exp = Arrays.asList( 
            /*different sources*/
            //new VariousStreamsExample()
            
            /* reducing the elements of a stream*/
            //new ReducingElementsExample()
            
            
            /*collecting the elements of a stream*/
            //new CollectorExample()
            
            /*action to every element of a stream*/
            //new EveryElementExample()
            
            /*filtering*/
            new FilterExample()

            /*transforming*/
            //new TransformingExample()
            
            /*sorting*/
            //new SortingExample()
            
            /*conditions*/
            //new ConditionsExample()
            
            
            /*reactive*/
            //new ReactiveExample()
            
            );

    exp.forEach((x) -> {
      x.demo();
    });
  }
}
