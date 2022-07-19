package com.nimsoc.objects;

import java.util.Objects;

public class Student {

  String studentId;
  int grade;
  String name;
  Teacher teacher;
  Student peer;

  public Student(String studentId, int grade, String name) {
    this.studentId = studentId;
    this.grade = grade;
    this.name = name;
  }

  public int getGrade() {
    return grade;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStudentId() {
    return studentId;
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 61 * hash + Objects.hashCode(this.studentId);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Student other = (Student) obj;
    if (!Objects.equals(this.studentId, other.studentId)) {
      return false;
    }
    return true;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public Student getPeer() {
    return peer;
  }

  public void setPeer(Student peer) {
    this.peer = peer;
  }

  boolean olympic; 

  public boolean isOlympic() {
    return olympic;
  }

  public void setOlympic(boolean olympic) {
    this.olympic = olympic;
  }
  
  public String getFirstLetterFromName() {
    return this.name.substring(0, 1);
  }

  @Override
  public String toString() {
    return "Student{" + "studentId=" + studentId + ", grade=" + grade + ", name=" + name + ", teacher=" + teacher + ", peer=" + peer + ", olympic=" + olympic + '}';
  }
  
}
