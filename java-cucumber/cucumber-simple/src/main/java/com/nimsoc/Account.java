package com.nimsoc;

public class Account {

  private Double balance;

  public Account(Double initialBalance) {
    this.balance = initialBalance;
  }

  public void credit(Double amount) {
    balance += amount;
  }

  public Double getBalance() {
    return balance;
  }
}
