package com.nimsoc.java_algorithms.recursion;

public class Hanoi {
  
  public void solve(int n, char from, char aux, char to) {
    if (n == 1) {
      System.out.println("Move 1 from " + from + " to " + to);
      return;
    }
    
    solve(n - 1, from, to, aux);
    System.out.println("Move " + n + " from " + from + " to " + to);
    solve(n - 1, aux, from, to);
  }
  
  public static void main(String[] args) {
    new Hanoi().solve(3, 'a', 'b', 'c');
  }
}
