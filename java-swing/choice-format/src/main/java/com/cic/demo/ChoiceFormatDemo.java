package com.cic.demo;

import java.text.ChoiceFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ChoiceFormatDemo {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    ChoiceFormatDemo cfd = new ChoiceFormatDemo();

    cfd.demonstrateChoiceFormatWithDoublesAndStringsArrays();

    cfd.demonstrateChoiceFormatWithStringPattern();

    cfd.demonstrateChoiceFormatBoundariesEnforced();

    cfd.demonstratePluralAndSingular();
    
    cfd.demonstrateLessThanOrEquals();

  }

  private static List<Double> fredsTestScores;

  static {
    final ArrayList<Double> scores = new ArrayList<>();
    scores.add(75.6);
    scores.add(88.8);
    scores.add(97.3);
    scores.add(43.3);
    fredsTestScores = Collections.unmodifiableList(scores);
  }

  private static List<Double> boundaryTestScores;

  static {
    final ArrayList<Double> boundaryScores = new ArrayList<Double>();
    boundaryScores.add(-25.0);
    boundaryScores.add(0.0);
    boundaryScores.add(20.0);
    boundaryScores.add(60.0);
    boundaryScores.add(70.0);
    boundaryScores.add(80.0);
    boundaryScores.add(90.0);
    boundaryScores.add(100.0);
    boundaryScores.add(115.0);
    boundaryTestScores = boundaryScores;
  }

  /**
   * Demonstrate ChoiceFormat instantiated with ChoiceFormat constructor that
   * accepts a String pattern.
   */
  public void demonstrateChoiceFormatWithStringPattern() {
    final String limitFormatPattern = "0#F | 60#D | 70#C | 80#B | 90#A";
    final ChoiceFormat gradesFormat = new ChoiceFormat(limitFormatPattern);
    writeGradeInformation(fredsTestScores, gradesFormat);
  }

  /**
   * Demonstrate ChoiceFormat instantiated with ChoiceFormat constructor that
   * accepts an array of double and an array of String.
   */
  public void demonstrateChoiceFormatWithDoublesAndStringsArrays() {
    final double[] minimumPercentages = {0, 60, 70, 80, 90};
    final String[] letterGrades = {"F", "D", "C", "B", "A"};
    final ChoiceFormat gradesFormat = new ChoiceFormat(minimumPercentages, letterGrades);
    writeGradeInformation(fredsTestScores, gradesFormat);
  }

  /**
   * Write grade information to standard output using the provided ChoiceFormat
   * instance.
   *
   * @param testScores Test Scores to be displayed with formatting.
   * @param gradesFormat ChoiceFormat instance to be used to format output.
   */
  public void writeGradeInformation(
          final Collection<Double> testScores,
          final ChoiceFormat gradesFormat) {
    double sum = 0;
    for (final Double testScore : testScores) {
      sum += testScore;
      System.out.println(testScore + " is a '" + gradesFormat.format(testScore) + "'.");
    }
    double average = sum / testScores.size();
    System.out.println(
            "The average score (" + average + ") is a '"
            + gradesFormat.format(average) + "'.");
  }

  /**
   * Demonstrating enforcing of lower and upper boundaries with ChoiceFormat
   * instances.
   */
  public void demonstrateChoiceFormatBoundariesEnforced() {
    // Demonstrating boundary enforcement with ChoiceFormat(double[], String[])
    final double[] minimumPercentages = {Double.NEGATIVE_INFINITY, 0, 60, 70, 80, 90, 100.000001};
    final String[] letterGrades = {"Invalid - Too Low", "F", "D", "C", "B", "A", "Invalid - Too High"};
    final ChoiceFormat gradesFormat = new ChoiceFormat(minimumPercentages, letterGrades);
    writeGradeInformation(boundaryTestScores, gradesFormat);

    // Demonstrating boundary enforcement with ChoiceFormat(String)
    final String limitFormatPattern = "-\u221E#Invalid - Too Low | 0#F | 60#D | 70#C | 80#B | 90#A | 100.0<Invalid - Too High";
    final ChoiceFormat gradesFormat2 = new ChoiceFormat(limitFormatPattern);
    writeGradeInformation(boundaryTestScores, gradesFormat2);
  }

  /**
   * Demonstrate ChoiceFormat used for differentiation of singular from plural
   * and none.
   */
  public void demonstratePluralAndSingular() {
    final double[] cactiLowerLimits = {0, 1, 2, 3, 4, 10};
    final String[] cactiRangeDescriptions
            = {"no cacti", "a cactus", "a couple cacti", "a few cacti", "many cacti", "a plethora of cacti"};
    final ChoiceFormat cactiFormat = new ChoiceFormat(cactiLowerLimits, cactiRangeDescriptions);
    for (int cactiCount = 0; cactiCount < 11; cactiCount++) {
      System.out.println(cactiCount + ": I own " + cactiFormat.format(cactiCount) + ".");
    }
  }

  /**
   * Demonstrate using \u2264 in String pattern for ChoiceFormat to represent >=
   * sign. Treated differently than less-than sign but similarly to #.
   */
  public void demonstrateLessThanOrEquals() {
    final String limitFormatPattern = "0\u2264F | 60\u2264D | 70\u2264C | 80\u2264B | 90\u2264A";
    final ChoiceFormat gradesFormat = new ChoiceFormat(limitFormatPattern);
    writeGradeInformation(fredsTestScores, gradesFormat);
  }
}
