import java.util.Scanner;

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

            String command = scanner.next();

            switch (command) {
                case "1":
                    System.out.println("Enter a month (from 0)");
                    int month = scanner.nextInt();
                    System.out.println("Enter a day (from 0)");
                    int day = scanner.nextInt();
                    System.out.println("Enter a quantity of steps");
                    int steps = scanner.nextInt();
                    if (steps > 0) {
                        System.out.println(stepTracker.saveStepsPerDay(month, day, steps));
                    }
                    else {
                        System.out.println("Inappropriate quantity of steps");
                    }
                    break;
                case "2":
                    System.out.println(2);
                    break;
                case "3":
                    System.out.println(3);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Inappropriate command. Choose a command from a list");
            }
        }
    }
}
