package com.h2;

import java.util.Map;
import java.util.Scanner;
public class BestLoanRates {

    public static final Map<Integer, Float> bestRates = Map.of(1, 5.5f, 2, 3.45f, 3, 2.67f);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name ");

        String name = scanner.nextLine();
        System.out.println("Hello " + name);
        System.out.println("Enter the loan term (in years)");
        int loanTermInYear = scanner.nextInt();

        float bestRate = getRates(loanTermInYear);

        if(bestRate == 0.0f){
            System.out.println("No available rates for term: " + loanTermInYear + " years");
        }
        else
        {
            System.out.println("Best Available Rate: " + getRates(loanTermInYear) + "%");
        }

        scanner.close();

    }

    public static float getRates(int loanTermInYears){
        if(bestRates.containsKey(loanTermInYears))
            return bestRates.get(loanTermInYears);
        else
            return 0.0f;
    }

}
