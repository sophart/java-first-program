package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {
    private float[] credits;
    private float[] debits;

    public SavingsCalculator(float[] credits, float[] debits) {
        this.credits = credits;
        this.debits = debits;
    }

    public static void main(String[] args) {
         String[] creditsAsString = args[0].split(",");
         String[] debitsAsString = args[1].split(",");

         float[] credits = new float[creditsAsString.length];

        for (int i = 0; i < creditsAsString.length; i++) {
            credits[i] = Utilities.getFloatValue(creditsAsString[i]);
        }


        float[] debits = new float[debitsAsString.length];

        for (int i = 0; i < debitsAsString.length; i++) {
            debits[i] = Utilities.getFloatValue(debitsAsString[i]);
        }

       SavingsCalculator calculator =  new SavingsCalculator(credits, debits);

        float  netSavings = calculator.calculate();
        String result = "Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now());

        System.out.println(result);
    }


    private float sumOfCredits() {
        float sum = 0.0f;

        for (float val :
                credits) {
            sum += val;
        }
        return sum;
    }

    private float sumOfDebits(){
        float sum = 0.0f;
        for (float val :
                debits) {
            sum += val;
        }

        return sum;
    }

    private static int remainingDaysInMonth(LocalDate date){
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        int remainingDays = totalDaysInMonth - date.getDayOfMonth();
        return remainingDays;
    }

    public float calculate(){
        return sumOfCredits() - sumOfDebits();
    }

}
