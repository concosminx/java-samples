package com.nimsoc.objects;

import java.util.Objects;
import java.util.Optional;

public class Teacher {

  private String name;
  private Optional<Student> pa;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Optional<Student> getPa() {
    return pa;
  }

  public void setPa(Optional<Student> student) {
    this.pa = student;
  }

  public Teacher(String name) {
    this.name = name;
  }

  @Override
  public int hashCode() {
    int hash = 3;
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
    final Teacher other = (Teacher) obj;
    if (!Objects.equals(this.name, other.name)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Teacher{" + "name=" + name + ", pa=" + pa + '}';
  }

}
