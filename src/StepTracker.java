import java.util.Scanner;

/**
 * <p>
 * Класс, обеспечивающий работу счётчика
 * </p>
 * Created on 11.09.2022
 *
 * @author VAlferov
 */

public class StepTracker {
    private final int[][] yearStatistics = new int[12][30];
    private int totalSteps = 10000;

    private final Scanner scanner = new Scanner(System.in);
    private final Converter converter = new Converter();

    public void setTotalSteps() {
        System.out.println("Enter new daily goal");
        int steps = scanner.nextInt();
        if (steps > 0) {
            totalSteps = steps;
            System.out.println("Daily goal was successfully updated");
        }
        else {
            System.out.println("Enter correct value");
        }
    }

    public void setStepsPerDay() {
        System.out.println("Enter a month (from 0)");
        int month = scanner.nextInt();
        System.out.println("Enter a day (from 0)");
        int day = scanner.nextInt();
        System.out.println("Enter a quantity of steps");
        int steps = scanner.nextInt();
        if (steps > 0) {
            yearStatistics[month][day] = steps;
            System.out.println("You successfully saved info about " + steps + " steps for " + day + "." + month);
        }
        else {
            System.out.println("Inappropriate quantity of steps");
        }
    }

    public void getStatisticsForMonth() {
        int month = scanner.nextInt();
        int[] daysSteps = yearStatistics[month];

        System.out.println("Enter a month (from 0)");

        System.out.println("Quantity of completed steps by days:");
        for (int currentDay = 1; currentDay < daysSteps.length; currentDay++) {
            System.out.print(currentDay + " day: " + daysSteps[currentDay-1] + ", ");
        }
        System.out.println("30 day: " + daysSteps[29]);

        System.out.println("Common quantity of steps for a month: " + getTotalMonthSteps(month));
        System.out.println("Max steps in month: " + getMaxSteps(month));
        System.out.println("Average quantity of steps: " + getAverageMonthSteps(month));
        System.out.println("Covered kilometers: " + getCoveredDistance(month));
        System.out.println("Burned kilocalories: " + getBurnedKiloCalories(month));
        System.out.println("Best streak: " + getBestStreak(month));
    }

    private int getTotalMonthSteps(int month) {
        int steps = 0;
        for (int daySteps : yearStatistics[month]) {
            steps+=daySteps;
        }
        return steps;
    }

    private double getAverageMonthSteps(int month) {
        int average = 0;
        for (int daySteps : yearStatistics[month]) {
            average+=daySteps;
        }
        return average/30;
    }

    private double getCoveredDistance(int month) {
        return converter.getKilometersFromSteps(getTotalMonthSteps(month));
    }

    private double getBurnedKiloCalories(int month) {
        return converter.getKiloCaloriesFromSteps(getTotalMonthSteps(month));
    }

    private int getBestStreak(int month) {
        int best = 0;
        int currentBest = 0;
        for (int daySteps : yearStatistics[month]) {
            if (daySteps >= totalSteps) {
                currentBest++;
            }
            else if (currentBest > best) {
                best = currentBest;
                currentBest = 0;
            }
        }
        return best;
    }

    private int getMaxSteps(int month) {
        int max = 0;
        for (int daySteps : yearStatistics[month]) {
            if (daySteps > max) {
                max = daySteps;
            }
        }
        return max;
    }
}
