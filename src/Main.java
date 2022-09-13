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

        int month;
        int day;
        int steps;

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("1. Enter a quantity of steps for a concrete day");
            System.out.println("2. Print statistics for a concrete month");
            System.out.println("3. Change a goal of steps per day");
            System.out.println("4. Exit");

            String command = scanner.next();

            switch (command) {
                case "1":
                    System.out.println("Enter a month (from 0)");
                    month = scanner.nextInt();
                    System.out.println("Enter a day (from 0)");
                    day = scanner.nextInt();
                    System.out.println("Enter a quantity of steps");
                    steps = scanner.nextInt();
                    if (steps > 0) {
                        System.out.println(stepTracker.setStepsPerDay(month, day, steps));
                    }
                    else {
                        System.out.println("Inappropriate quantity of steps");
                    }
                    break;
                case "2":
                    System.out.println("Enter a month (from 0)");
                    month = scanner.nextInt();
                    int[] daysSteps = stepTracker.getStatisticsForMonth(month);

                    System.out.println("Quantity of completed steps by days:");
                    for (int currentDay = 1; currentDay < daysSteps.length; currentDay++) {
                        System.out.print(currentDay + " day: " + daysSteps[currentDay-1] + ", ");
                    }
                    System.out.println("30 day: " + daysSteps[29]);
                    //при неточном количестве месяцев использовал бы substring, удалив последние два символа

                    System.out.println("Common quantity of steps for a month: " + stepTracker.getTotalMonthSteps(month));
                    System.out.println("Max steps in month: " + stepTracker.getMaxSteps(month));
                    System.out.println("Average quantity of steps: " + stepTracker.getAverageMonthSteps(month));
                    System.out.println("Covered kilometers: " + stepTracker.getCoveredDistance(month));
                    System.out.println("Burned kilocalories: " + stepTracker.getBurnedKiloCalories(month));
                    System.out.println("Best streak: " + stepTracker.getBestStreak(month));

                    break;
                case "3":
                    System.out.println("Enter new daily goal");
                    steps = scanner.nextInt();
                    System.out.println(stepTracker.setTotalSteps(steps));
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Inappropriate command. Choose a command from a list");
            }
        }
    }
}
