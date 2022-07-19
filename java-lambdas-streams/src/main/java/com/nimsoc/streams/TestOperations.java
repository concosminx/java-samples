package com.nimsoc.streams;

import com.nimsoc.objects.Artist;
import com.nimsoc.objects.Song;
import com.nimsoc.objects.Student;
import com.nimsoc.utils.SongUtil;
import com.nimsoc.utils.StudentUtil;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestOperations {

  public static void main(String[] args) {
    List<Student> students = StudentUtil.createStudents();

    TestOperations to = new TestOperations();

    to.testDistinct(students);
    System.out.println("---------");
    to.testLimit(students);
    System.out.println("---------");
    to.testSkip(students);
    System.out.println("---------");
    to.testFiltering(students);
    System.out.println("---------");
    to.testFindAny(students);
    System.out.println("---------");
    to.testFindFirst(students);
    System.out.println("---------");
    to.testAnyMatch(students);
    System.out.println("---------");
    to.testAllMatch(students);
    System.out.println("---------");
    to.testNoneMatch(students);
    System.out.println("---------");
    to.flatMapSongs();
    System.out.println("---------");
    to.flatMapBeers();
    System.out.println("---------");
    to.groupingByGrade(students);
    System.out.println("---------");
    to.groupingByGradeAndFirstLetterOfName(students);
    System.out.println("---------");
    to.testMapping(students);
    System.out.println("---------");
    to.attendeesOptional();
    System.out.println("---------");
    to.noAttendeesOptional();
    System.out.println("---------");
    to.creatingOptionals();
    System.out.println("---------");
    try {
      to.ifElseOptionals();
    } catch (Exception e1) {
      e1.printStackTrace();
    }
    System.out.println("---------");
    try {
      to.ifElseThrowOptionals();
    } catch (Exception e) {
      System.out.println("Expected exception:" + e);
    }
    System.out.println("---------");
    to.filterMapOptionals();
    System.out.println("---------");
    to.attendeesOptional();
    System.out.println("---------");
    to.noAttendeesOptional();

    to.partitionByExecutives(students);
    System.out.println("---------");
    to.partitioningAndGrouping(students);
    System.out.println("---------");
    to.partitioningMultiLevel(students);
    System.out.println("---------");

    to.schoolStaff();
    System.out.println("---------");
    to.totalGrades();
    System.out.println("---------");
    to.genreList();
    System.out.println("---------");
    
    to.range();
    System.out.println("---------");
    to.testMaxAndMin();
    System.out.println("---------");
    
    

  }

  private void testDistinct(List<Student> students) {
    Stream<String> studentsStream
            = students
                    .stream()
                    .map(Student::getName)
                    .distinct();
    studentsStream.forEach(System.out::println);
  }

  private void testLimit(List<Student> students) {
    Stream<String> studentsStream
            = students
                    .stream()
                    .map(Student::getName)
                    .distinct()
                    .limit(2);

    studentsStream.forEach(System.out::println);
  }

  private void testSkip(List<Student> students) {
    Stream<String> studentsStream
            = students
                    .stream()
                    .skip(2)
                    .map(Student::getName);
    studentsStream.forEach(System.out::println);
  }

  private void testFiltering(List<Student> students) {
    Stream<Student> studentsStream = students
            .stream()
            .filter(s -> s.getStudentId().startsWith("1"))
            .filter(s -> 7 == s.getGrade());
    studentsStream.forEach(System.out::println);
  }

  private void testFindFirst(List<Student> students) {
    Optional<Student> firstStudent = students.stream()
            .filter(s -> s.getGrade() > 5)
            .findFirst();
    System.out.println("First student: " + firstStudent.get());
  }

  private void testFindAny(List<Student> students) {
    Optional<Student> anyStudent = students.stream()
            .filter(s -> s.getGrade() > 5)
            .findAny();
    System.out.println("Any student: " + anyStudent.get());
  }

  private void testAnyMatch(List<Student> students) {
    boolean isJohn = students.stream().anyMatch(s -> "John".equalsIgnoreCase(s.getName()));
    System.out.println("Is John?:" + isJohn);
  }

  private void testAllMatch(List<Student> students) {
    boolean grThanFive = students.stream()
            .allMatch(s -> s.getGrade() > 5);
    System.out.println("> 5:" + grThanFive);
  }

  private void testNoneMatch(List<Student> students) {
    boolean olympic = students.stream().noneMatch(s -> s.isOlympic() && s.getGrade() < 7);
    System.out.println("Is olympic ?: " + olympic);
  }

  private void flatMapSongs() {
    List<Song> songs = SongUtil.createSongsAndActors();
    Stream<Artist> artistStream = songs.stream().flatMap(s -> s.getArtists().stream());
    artistStream.forEach(System.out::println);
  }

  private void flatMapBeers() {
    String[] beers1 = new String[]{"Becks", "Heineken"};
    String[] beers2 = new String[]{"Salitos", "Corona"};
    Stream<List<String>> fruitsAndVeggies = Stream.of(Arrays.asList(beers1), Arrays.asList(beers2));
    fruitsAndVeggies.flatMap(s -> s.stream()).forEach(System.out::println);
  }

  private void groupingByGrade(List<Student> students) {
    Map<Integer, List<Student>> std = students.stream()
            .collect(Collectors.groupingBy(s -> s.getGrade()));
    System.out.println(std);
  }

  private void groupingByGradeAndFirstLetterOfName(List<Student> students) {
    Map<Integer, Map<String, List<Student>>> r2
            = students.stream()
                    .collect(groupingBy((Student::getGrade), groupingBy(Student::getFirstLetterFromName)));
    System.out.println(r2);
  }

  private void testMapping(List<Student> students) {
    Stream<String> stream = students
            .stream()
            .map(Student::getName)
            .map(String::toUpperCase);

    stream.forEach(System.out::println);
  }

  private void creatingOptionals() {
    Student student = new Student("100", 5, "Jerry");
    Optional<Student> studentOptional = Optional.of(student);
    System.out.println(studentOptional.get());
    studentOptional.ifPresent(System.out::println);
    student = null;
    Optional<Student> studentOptional2 = Optional.ofNullable(student);
    System.out.println("Student can't be null:" + studentOptional2);

  }

  private void ifElseOptionals() {
    Student student = null;
    Student defaultStudent = new Student("100", 5, "Jerry");
    defaultStudent.setName("Default Jerry");
    Optional<Student> studentOptional = Optional.ofNullable(student);
    String name = studentOptional.orElse(defaultStudent).getName();
    System.out.println("Name? : " + name);
  }

  private void ifElseThrowOptionals() throws Exception {
    Student student = null;
    Optional<Student> studentOptional = Optional.ofNullable(student);
    studentOptional.orElseThrow(Exception::new);
  }

  private void filterMapOptionals() {
    Student st = new Student("100", 5, "Jerry");
    st.setName("John");
    Optional<Student> stOptional = Optional.of(st);
    stOptional.filter(student -> student.isOlympic()).ifPresent(System.out::println);
    stOptional.map(s -> s.getName()).ifPresent(System.out::println);
  }

  private void attendeesOptional() {
    List<Integer> attendees = Arrays.asList(11, 33, 44, 22);
    Optional<Integer> attendeesOptional = attendees.stream().reduce(Integer::sum);
    System.out.println(attendeesOptional.get());
  }

  private void noAttendeesOptional() {
    List<Integer> attendees = Arrays.asList();
    Optional<Integer> noAttendees = attendees.stream().reduce(Integer::sum);
    if (noAttendees.isPresent()) {
      System.out.println(noAttendees.get());
    }
  }

  private void partitionByExecutives(List<Student> students) {
    Map<Boolean, List<Student>> part = students.stream().collect(Collectors.partitioningBy(Student::isOlympic));
    System.out.println(part);
  }

  private void partitioningAndGrouping(List<Student> students) {
    Map<Boolean, Map<String, List<Student>>> part
            = students.stream().collect(partitioningBy((Student::isOlympic), groupingBy(Student::getFirstLetterFromName)));

    part.keySet().forEach((b) -> {
      System.out.println(b + " --> " + part.get(b));
    });
  }

  private void partitioningMultiLevel(List<Student> students) {
    Map<Boolean, Map<Boolean, List<Student>>> part
            = students.stream().collect(partitioningBy((Student::isOlympic), partitioningBy((s -> s.getName().startsWith("J")))));
    part.keySet().forEach((b) -> {
      System.out.println(b + " ==> " + part.get(b));
    });
  }

  private void genreList() {
    List<Song> songs = SongUtil.createSongs();
    Optional<String> instList = songs.stream()
            .map(Song::getGenre)
            .reduce((a, b) -> a + "," + b);
    System.out.println(instList);
  }

  private void schoolStaff() {
    List<Integer> ints = Arrays.asList(1, 3, 2, 5);
    int staff = ints.stream().reduce(10, (i, j) -> i + j);
    System.out.println("Total: " + staff);
  }

  private void totalGrades() {
    List<Student> stds = StudentUtil.createStudents();
    Optional<Integer> totalQuantity
            = stds.stream()
                    .map(Student::getGrade)
                    .reduce((a, b) -> a + b);
    System.out.println("Total grades: " + totalQuantity.get());
  }

  private void range() {
    IntStream ints = IntStream.rangeClosed(10, 20);
    ints.forEach(System.out::println);
  }

  private void testMaxAndMin() {
    IntStream ints = IntStream.rangeClosed(10, 20);
    OptionalInt max = ints.max();
    System.out.println("Max: " + max.getAsInt());

    ints = IntStream.rangeClosed(10, 20);
    OptionalInt min = ints.min();
    System.out.println("Min: " + min.getAsInt());

    ints = IntStream.rangeClosed(10, 20);
    OptionalDouble avg = ints.average();
    System.out.println("Min: " + avg.getAsDouble());

  }
}
