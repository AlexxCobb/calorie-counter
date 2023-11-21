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

        System.out.println("Введите номер месяца");
        Scanner scanner1 = new Scanner(System.in);
        int i = scanner.nextInt();
        if (i < 1 || i > 12) {
            System.out.println("Введен несуществующий месяц, у нас их 12, попробуйте еще раз.");
            return;
        }

        System.out.println("Введите день, от 1 до 30 (включительно");
        Scanner scanner2 = new Scanner(System.in);
        int j = scanner.nextInt();
        if (j < 1 || j > 30) {
            System.out.println("Введено несуществующее значение. В нашем календаре 30 дней в каждом месяце. Try again!");
            return;
        }

        System.out.println("Введите количество шагов");
        Scanner scanner3 = new Scanner(System.in);
        int f = scanner.nextInt();
        if (f < 0) {
            System.out.println("ШТА? Количество шагов должно быть положительным числом!");
            return;
        }

        MonthData monthData = monthToData[i - 1];
        monthData.days[j - 1] = f;

    }

    void changeStepGoal() {
        System.out.println("Введите новое количество шагов");
        Scanner scanner = new Scanner(System.in);
        int newTarget = scanner.nextInt();
        if (newTarget <= 0) {
            System.out.println("Вы ввели в качестве цели отрицательное число или 0. Не надо так)");
        } else goalByStepsPerDay = newTarget;
    }

    void printStatistic() {
        System.out.println("Введите номер месяца,за который нужно вывести статистику");
        Scanner scanner = new Scanner(System.in);
        int numberOfMonth = scanner.nextInt();
        if (numberOfMonth < 1 || numberOfMonth > 12) {
            System.out.println("Вы ввели неверное значение. Введите месяц от 1 до 12 включительно");
        }
        MonthData monthData = monthToData[numberOfMonth - 1];


        int sumSteps = monthData.sumStepsFromMonth();
        monthData.printDaysAndStepsFromMonth();
        System.out.println();
        System.out.println("Общее количество пройденных шагов за месяц: " + sumSteps);
        System.out.println("Максимальное количество шагов, которое Вы прошли за месяц: " + monthData.maxSteps());
        System.out.println("Среднее количество шагов, которое Вы прошли за месяц: " + sumSteps / monthData.days.length);
        System.out.println("Всего вы прошли " + converter.convertToKm(sumSteps) + " км");
        System.out.println("Сожгли за этот месяц " + converter.convertStepsToKilocalories(sumSteps) + " килокалорий");
        System.out.println("Лучшая серия дней, где выполнена цель по шагам - " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();

    }


}












