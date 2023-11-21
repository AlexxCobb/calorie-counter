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
                System.out.println("�������� ����� ��������!");
                scanner.close();
                return;
            }else {
                System.out.println("����� ������� ���, ��� ���� �� ���������. ���������� ��� ���!");
            }
        }
    }

    static void printMenu() {
        System.out.println("������������! ������� ���������� ����� �������, ������� ����� �����������:");
        System.out.println("1 - ������ ���������� ����� �� ����������� ����");
        System.out.println("2 - �������� ���� �� ���������� ����� � ����");
        System.out.println("3 - ���������� ���������� �� ����������� �����");
        System.out.println("0 - ����� �� ����������");
        System.out.println();
    }
}


