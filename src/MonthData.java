import java.util.Scanner;

public class MonthData {

    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
       for (int i = 0; i < days.length; i++) {
           System.out.println((i+1) + " день: " + days[i] + " шагов.");
       }
    }


    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps += days[i];
        }
        return sumSteps;
    }


    int maxSteps() {
        int maxElement = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxElement){
                maxElement = days[i];
            }
        }
        return maxElement;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                currentSeries++;
            } else currentSeries = 0;
            if (currentSeries > finalSeries) {
                finalSeries = currentSeries;
            }
        }

        return finalSeries;
    }
}
