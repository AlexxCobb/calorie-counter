import java.util.Scanner;

public class StepTracker {

    Converter converter = new Converter();

    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;

    public StepTracker(Scanner scan) {
        this.scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца (с 1 по 12):");
        int i = scanner.nextInt();
        if (i < 1 || i > 12) {
            System.out.println("Введено некорректное значение месяца. Начните сначала.");
            return;
        }

        System.out.println("Введите дату (с 1 по 30): ");
        int j = scanner.nextInt();
        if (j < 1 || j > 30) {
            System.out.println("Введена некорректная дата. Начните сначала.");
            return;
        }

        System.out.println("Введите количество пройденных шагов: ");
        int f = scanner.nextInt();
        if (f < 0) {
            System.out.println("Количество шагов не должно быть отрицательным. Начните сначала.");
            return;
        }
        MonthData monthData = monthToData[i - 1];
        monthData.days[j - 1] = f;
    }

    void changeStepGoal() {
        System.out.println("Новая цель по количеству шагов!");
        Scanner scanner = new Scanner(System.in);
        int newTarget = scanner.nextInt();
        if (newTarget <= 0) {
            System.out.println("Количество шагов не должно быть отрицательным. Начните сначала.");
        } else goalByStepsPerDay = newTarget;
    }

    void printStatistic() {
        System.out.println("Введите номер месяца, за который вывести статистику:");
        Scanner scanner = new Scanner(System.in);
        int numberOfMonth = scanner.nextInt();
        if (numberOfMonth < 1 || numberOfMonth > 12) {
            System.out.println("Введено некорректное значение месяца. Начните сначала.");
        }
        MonthData monthData = monthToData[numberOfMonth - 1];

        int sumSteps = monthData.sumStepsFromMonth();
        monthData.printDaysAndStepsFromMonth();
        System.out.println();
        System.out.println("Всего пройдено шагов за месяц - " + sumSteps);
        System.out.println("Максимальное количество шагов за день - " + monthData.maxSteps());
        System.out.println("Среднее количество шагов за месяц - " + sumSteps / monthData.days.length);
        System.out.println("Пройденная дистанция за месяц - " + converter.convertToKm(sumSteps) + " км");
        System.out.println("Сожженные килокалории - " + converter.convertStepsToKilocalories(sumSteps));
        System.out.println(
                "Лучшая серия по количеству шагов подряд пройденных дней - " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();
    }
}