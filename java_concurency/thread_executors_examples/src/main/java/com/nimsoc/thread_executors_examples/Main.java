package com.nimsoc.thread_executors_examples;

import com.nimsoc.thread_executors_examples.cancel.CTask;
import com.nimsoc.thread_executors_examples.cancel.CancelExample;
import com.nimsoc.thread_executors_examples.ctrl.ControlTaskExample;
import com.nimsoc.thread_executors_examples.ctrl.ExecutableTask;
import com.nimsoc.thread_executors_examples.ctrl.ResultTask;
import com.nimsoc.thread_executors_examples.delay.DTask;
import com.nimsoc.thread_executors_examples.delay.DelayExample;
import com.nimsoc.thread_executors_examples.factorial.FactorialCalc;
import com.nimsoc.thread_executors_examples.factorial.ReturningResultExample;
import com.nimsoc.thread_executors_examples.period.PTask;
import com.nimsoc.thread_executors_examples.period.PeriodicallyExample;
import com.nimsoc.thread_executors_examples.rejected.RejectedTask;
import com.nimsoc.thread_executors_examples.rejected.RejectedTaskExample;
import com.nimsoc.thread_executors_examples.rejected.Server;
import com.nimsoc.thread_executors_examples.reports.LaunchProcessExample;
import com.nimsoc.thread_executors_examples.reports.ReportProcessor;
import com.nimsoc.thread_executors_examples.reports.ReportRequest;
import com.nimsoc.thread_executors_examples.results.AllResultsExample;
import com.nimsoc.thread_executors_examples.results.ImResult;
import com.nimsoc.thread_executors_examples.results.ImTask;
import com.nimsoc.thread_executors_examples.validation.FirstResultExample;
import com.nimsoc.thread_executors_examples.validation.UserValidator;
import com.nimsoc.thread_executors_examples.validation.ValidatorTask;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosminx
 */
public class Main {

  public static void main(String[] args) {
    List<Example> exp = Arrays.asList(
            /*task rejection when executor has been shutdown*/
            //new RejectedTaskExample()

            /*task that returns a result*/
            //new ReturningResultExample()
            
            /*first result from multiple tasks*/
            //new FirstResultExample()
            
            /*processing all the results*/
            //new AllResultsExample()
            
            /*running a task after a delay*/
            //new DelayExample()
            
            /* running periodically*/
            //new PeriodicallyExample()
            
            /* cancel a task */
            //new CancelExample()
            
            
            /* control task finishing*/
            //new ControlTaskExample()
            
            /* launch and process */
            new LaunchProcessExample()
    );

    exp.forEach((x) -> {
      x.demo();
    });

  }

 
}
