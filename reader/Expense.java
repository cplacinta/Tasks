package reader;

import java.util.Date;

public class Expense {
  private Date date;
  private String tag;
  private double amount;
  private double income;
  private String currency;
  private String description;

  @Override
  public String toString() {
    return "Date: "+date +":   Tag: " + tag+ "   Amount: " + amount+"    Income:" + income +"    Currency:"+currency+"     Description:" + description;
  }

  public Expense(Date date, String tag, double amount, double income,  String currency, String description){
    this.date = date;
    this.tag = tag;
    this.amount = amount;
    this.income = income;
    this.currency = currency;
    this.description = description;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public double getIncome() {
    return income;
  }

  public void setIncome(int income) {
    this.income = income;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
