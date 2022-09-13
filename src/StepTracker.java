import java.util.Arrays;

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

    private final LocalConverter converter = new LocalConverter();

    public String setTotalSteps(int steps) {
        if (steps > 0) {
            totalSteps = steps;
            return "Daily goal was successfully updated";
        }
        else {
            return "Enter correct value";
        }
    }

    public String setStepsPerDay(int month, int day, int steps) {
        yearStatistics[month][day] = steps;
        return "You successfully saved info about " + steps + " steps for " + day + "." + month;
    }

    public int[] getStatisticsForMonth(int month) {
        return yearStatistics[month];
    }

    public int getTotalMonthSteps(int month) {
        int steps = 0;
        for (int daySteps : yearStatistics[month]) {
            steps+=daySteps;
        }
        return steps;
    }

    public double getAverageMonthSteps(int month) {
        int average = 0;
        for (int daySteps : yearStatistics[month]) {
            average+=daySteps;
        }
        return average/30;
    }

    public double getCoveredDistance(int month) {
        return converter.getKilometersFromSteps(getTotalMonthSteps(month));
    }

    public double getBurnedKiloCalories(int month) {
        return converter.getKiloCaloriesFromSteps(getTotalMonthSteps(month));
    }

    public int getBestStreak(int month) {
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

    public int getMaxSteps(int month) {
        int max = 0;
        for (int daySteps : yearStatistics[month]) {
            if (daySteps > max) {
                max = daySteps;
            }
        }
        return max;
    }
}
