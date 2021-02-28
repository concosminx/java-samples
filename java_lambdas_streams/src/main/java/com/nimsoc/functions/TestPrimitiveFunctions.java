package com.nimsoc.functions;

import com.nimsoc.objects.Student;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.Predicate;

public class TestPrimitiveFunctions {

  /*predicates*/
  Predicate<Integer> evenNumber = x -> x % 2 == 0;
  IntPredicate evenNumberPrimitive = x -> x % 2 == 0;

  Predicate<Double> doublePredicate = x -> x > 10;
  DoublePredicate doublePredicate2 = x -> x > 10;
  LongPredicate longPredicate = null;

  /*consumers*/
  IntConsumer intConsumer = null;
  DoubleConsumer doubleConsumer = null;
  LongConsumer longConsumer = null;

  /*suppliers*/
  IntSupplier intSupplier;
  DoubleSupplier doubleSupplier;
  LongSupplier longSupplier;

  /*functions*/
  Function<Integer, Student> studentFunction = null;

  IntFunction<Student> empFunciton2 = null;
  DoubleFunction<Student> doubleEmpFunction;
  LongFunction<Student> longEmpFunction;

  /*double and int*/
  Function<Double, Integer> doubleToIntegerFunction = null;
  DoubleFunction<Integer> doubleToIntegerFunction2;

  /*primitive to primitive*/
  DoubleToIntFunction doubleToIntegerFunction3;
}
