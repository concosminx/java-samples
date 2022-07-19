package com.nimsoc.java_algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class Hanoi {

  private final List<String> moves = new ArrayList<>();

  public List<String> getMoves() {
    return moves;
  }

  public void solve(int n, char from, char aux, char to) {
    if (n == 1) {
      moves.add(from + "-" + to);
      return;
    }
    solve(n - 1, from, to, aux);
    moves.add(from + "-" + to);
    solve(n - 1, aux, from, to);
  }


}
