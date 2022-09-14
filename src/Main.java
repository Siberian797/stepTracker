import java.util.Scanner;

/**
 * <p>
 * Основной класс приложения
 * </p>
 * Created on 11.09.2022
 *
 * @author VAlferov
 *
 * Прошу прощения за английский вариант
 * Всё перепробовал, но в консоль русский никак не выводится
 */

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("1. Enter a quantity of steps for a concrete day");
            System.out.println("2. Print statistics for a concrete month");
            System.out.println("3. Change a goal of steps per day");
            System.out.println("4. Exit");

            String inputMenuItem = scanner.next();

            switch (inputMenuItem) {
                case "1":
                    stepTracker.setStepsPerDay();
                    break;
                case "2":
                    stepTracker.getStatisticsForMonth();
                    break;
                case "3":
                    stepTracker.setTotalSteps();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Inappropriate command. Choose a command from a list");
            }
        }
    }
}
