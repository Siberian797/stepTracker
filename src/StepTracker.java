import java.util.Arrays;

public class StepTracker {
    private int[][] yearStatistics = new int[12][30];
    private int totalSteps = 10000;

    public String changeTotalSteps(int steps) {
        if (steps > 0) {
            totalSteps = steps;
            return "Daily goal was successfully updated";
        }
        else {
            return "Enter correct value";
        }
    }

    public String saveStepsPerDay(int month, int day, int steps) {
        yearStatistics[month][day] = steps;
        return "You successfully saved info about " + steps + " steps for " + day + "." + month;
    }
}
