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

        System.out.println("������� ����� ������");
        Scanner scanner1 = new Scanner(System.in);
        int i = scanner.nextInt();
        if (i < 1 || i > 12) {
            System.out.println("������ �������������� �����, � ��� �� 12, ���������� ��� ���.");
            return;
        }

        System.out.println("������� ����, �� 1 �� 30 (������������");
        Scanner scanner2 = new Scanner(System.in);
        int j = scanner.nextInt();
        if (j < 1 || j > 30) {
            System.out.println("������� �������������� ��������. � ����� ��������� 30 ���� � ������ ������. Try again!");
            return;
        }

        System.out.println("������� ���������� �����");
        Scanner scanner3 = new Scanner(System.in);
        int f = scanner.nextInt();
        if (f < 0) {
            System.out.println("���? ���������� ����� ������ ���� ������������� ������!");
            return;
        }

        MonthData monthData = monthToData[i - 1];
        monthData.days[j - 1] = f;

    }

    void changeStepGoal() {
        System.out.println("������� ����� ���������� �����");
        Scanner scanner = new Scanner(System.in);
        int newTarget = scanner.nextInt();
        if (newTarget <= 0) {
            System.out.println("�� ����� � �������� ���� ������������� ����� ��� 0. �� ���� ���)");
        } else goalByStepsPerDay = newTarget;
    }

    void printStatistic() {
        System.out.println("������� ����� ������,�� ������� ����� ������� ����������");
        Scanner scanner = new Scanner(System.in);
        int numberOfMonth = scanner.nextInt();
        if (numberOfMonth < 1 || numberOfMonth > 12) {
            System.out.println("�� ����� �������� ��������. ������� ����� �� 1 �� 12 ������������");
        }
        MonthData monthData = monthToData[numberOfMonth - 1];


        int sumSteps = monthData.sumStepsFromMonth();
        monthData.printDaysAndStepsFromMonth();
        System.out.println();
        System.out.println("����� ���������� ���������� ����� �� �����: " + sumSteps);
        System.out.println("������������ ���������� �����, ������� �� ������ �� �����: " + monthData.maxSteps());
        System.out.println("������� ���������� �����, ������� �� ������ �� �����: " + sumSteps / monthData.days.length);
        System.out.println("����� �� ������ " + converter.convertToKm(sumSteps) + " ��");
        System.out.println("������ �� ���� ����� " + converter.convertStepsToKilocalories(sumSteps) + " �����������");
        System.out.println("������ ����� ����, ��� ��������� ���� �� ����� - " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();

    }


}












