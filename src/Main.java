import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);


        while (true) {
            printMenu();
            int i = scanner.nextInt();

            if (i == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (i == 2) {
                stepTracker.changeStepGoal();
            } else if (i == 3) {
                stepTracker.printStatistic();
            } else if (i == 0) {
                System.out.println("Увидимся когда увидимся!");
                scanner.close();
                return;
            }else {
                System.out.println("Такой команды нет, или пока не придумали. Попробуйте еще раз!");
            }
        }
    }

    static void printMenu() {
        System.out.println("Здравствуйте! Введите пожалуйста номер команды, которая будет выполняться:");
        System.out.println("1 - ввести количество шагов за определённый день");
        System.out.println("2 - изменить цель по количеству шагов в день");
        System.out.println("3 - напечатать статистику за определённый месяц");
        System.out.println("0 - выйти из приложения");
        System.out.println();
    }
}


