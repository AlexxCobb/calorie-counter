import java.util.Scanner;

public class Converter {
    int oneStepToDistance = 75;
    int oneStepToCalories = 50;
    int metersInKm = 1000;
    int santimInMeter = 100;
    int kiloCalories = 1000;


    int convertToKm(int steps) {
        return (steps * oneStepToDistance) / santimInMeter / metersInKm ;
    }

    int convertStepsToKilocalories(int steps) {
        return (steps * oneStepToCalories) / kiloCalories;
    }



}
