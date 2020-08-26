package com.deen;

import javax.swing.*;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	//Mortgage Calculator
        // M= Mortgage P= Principal r= rate n = number of years

    final byte MONTHS_IN_YEAR= 12;
    final byte PERCENT= 100;
    int principal= 0;
    float monthlyInterest=0;
    int numberOfPayments=0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        //Inserting an Infinite loop
        while(true) {
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1000000");
        }

        System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

            System.out.print("Period(Years): ");
        while (true) {
            byte years = scanner.nextByte();
            if (years > 1 && years <= 5) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 5");
        }

        double mortgage = principal* (monthlyInterest* Math.pow(1 + monthlyInterest,numberOfPayments)
                / (Math.pow(1 + monthlyInterest,numberOfPayments)-1));

        String mortgageFormatted= NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: "+ mortgageFormatted);

    }
}
