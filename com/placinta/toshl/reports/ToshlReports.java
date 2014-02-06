package com.placinta.toshl.reports;

import reader.Expense;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToshlReports {
  public static void main(String[] args) throws IOException {

    String csvFileToRead = "C:\\toshl.csv";
    BufferedReader br = null;
    String line = "";
    String splitBy = "\",\"";
    int i = 0;
    double amount;
    double income;

    try {

      br = new BufferedReader(new FileReader(csvFileToRead));
      line = br.readLine();
      while ((line = br.readLine()) != null) {

        String[] expense = line.split(splitBy);
        Expense[] personalExpenses = new Expense[1000];

        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
        String str = expense[0].replace('"','\u0000');
        Date date = formatter.parse(str.trim());

        if (expense[2].equals("")) {
          amount = 0;
        } else {
          amount = Double.parseDouble(expense[2]);
        }
        if (expense[3].equals("")) {
          income = 0;
        } else {
          income = Double.parseDouble(expense[3]);
        }

        personalExpenses[i] = new Expense(date, expense[1], amount, income, expense[4], expense[5]);
        System.out.println(personalExpenses[i].toString());
        i++;
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    System.out.println("Done with reading CSV");
  }
}  