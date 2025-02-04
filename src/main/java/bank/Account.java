package bank;

import bank.exceptions.AmountException;

public class Account {
  private int id;
  private String type;
  private double balance;

  public Account(int id, String type, double balance) {
    setId(id);
    setType(type);
    setBalance(balance);
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void deposit(double amount) throws AmountException {
    if (amount < 1) {
      throw new AmountException("Amount must be greater than 1.00");
    } else {
      double newBalance = getBalance() + amount;
      setBalance(newBalance);
      DataSource.updateAccountBalance(id, newBalance);
    }

  }

  public void withdraw(double amount) throws AmountException {

    if (amount < 1) {
      throw new AmountException("Amount must be greater than 1.00");
    } else if (amount > getBalance()) {
      throw new AmountException("You do not have sufficient funds to withdraw that amount");
    } else {
      double newBalance = getBalance() - amount;
      setBalance(newBalance);
      DataSource.updateAccountBalance(id, newBalance);
    }

  }

}
