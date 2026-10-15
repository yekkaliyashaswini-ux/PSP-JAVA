import java.util.InputMismatchException;
import java.util.Scanner;

class User {
    private final String name;
    private final int age;
    private final double weight;
    private final double height;

    public User(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public double calculateBMI() {
        return weight / (height * height);
    }

    public boolean isAdult() {
        return age >= 18;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getWeight() { return weight; }
}

class Activity {
    private final String workoutName;
    private final int duration;
    private final double calories;

    public Activity(String workoutName, int duration, double calories) {
        this.workoutName = workoutName;
        this.duration = duration;
        this.calories = calories;
    }

    public boolean isLongWorkout() {
        return duration >= 30;
    }

    public double getRemainingCalories(double target) {
        return Math.max(0, target - calories);
    }

    public void displayStatus() {
        if (duration >= 30 && calories >= 200) {
            System.out.println("Fitness Status: Excellent workout!");
        } else if (duration >= 20 || calories >= 150) {
            System.out.println("Fitness Status: Good workout!");
        } else {
            System.out.println("Fitness Status: Try to exercise more.");
        }
    }

    public String getWorkoutName() { return workoutName; }
    public int getDuration() { return duration; }
    public double getCalories() { return calories; }
}

public class PersonalFitnessTracker1 {

    static void displaySummary(User user, Activity activity) {
        System.out.println("\n----- WORKOUT DETAILS -----");
        System.out.println("Name: " + user.getName());
        System.out.println("Age: " + user.getAge());
        System.out.println("Weight: " + user.getWeight() + " kg");
        System.out.println("Workout: " + activity.getWorkoutName());
        System.out.println("Duration: " + activity.getDuration() + " minutes");
        System.out.println("Calories Burned: " + activity.getCalories() + " kcal");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" PERSONAL FITNESS & WORKOUT TRACKER");
        System.out.println("=================================");

        try {
            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            System.out.print("Enter your weight in kg: ");
            double weight = sc.nextDouble();

            System.out.print("Enter your height in meters: ");
            double height = sc.nextDouble();

            System.out.print("Enter workout duration in minutes: ");
            int duration = sc.nextInt();

            System.out.print("Enter calories burned: ");
            double calories = sc.nextDouble();
            sc.nextLine(); 

            System.out.print("Enter workout name: ");
            String workout = sc.nextLine();

            User user = new User(name, age, weight, height);
            Activity activity = new Activity(workout, duration, calories);

            displaySummary(user, activity);

            double bmi = user.calculateBMI();
            System.out.printf("BMI: %.2f%n", bmi);
            if (bmi < 25) {
                System.out.println("BMI Check: BMI is below 25.");
            } else {
                System.out.println("BMI Check: BMI is 25 or above.");
            }

            activity.displayStatus();

            System.out.println("\n----- OPERATOR RESULTS -----");
            System.out.println("Workout duration + 10 = " + (activity.getDuration() + 10));
            System.out.println("Calories remaining from 500 = " + activity.getRemainingCalories(500));
            System.out.println("Age 18 or above: " + user.isAdult());
            System.out.println("Workout 30 minutes or more: " + activity.isLongWorkout());

            System.out.println("\n----- WEEKLY WORKOUT ARRAY -----");
            int[] weeklyMinutes = {30, 45, 20, 60, 35, 40, 50};
            int totalMinutes = 0;

            for (int i = 0; i < weeklyMinutes.length; i++) {
                System.out.println("Day " + (i + 1) + ": " + weeklyMinutes[i] + " minutes");
                totalMinutes += weeklyMinutes[i];
            }
            System.out.println("Total weekly workout minutes: " + totalMinutes);

            if (totalMinutes >= 250) {
                System.out.println("Milestone: You achieved more than 250 workout minutes!");
            }

            System.out.println("\n----- WORKOUT MENU -----");
            System.out.println("1. Running\n2. Walking\n3. Cycling\n4. Swimming");
            System.out.print("Choose workout type (1-4): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> System.out.println("Selected: Running");
                case 2 -> System.out.println("Selected: Walking");
                case 3 -> System.out.println("Selected: Cycling");
                case 4 -> System.out.println("Selected: Swimming");
                default -> System.out.println("Invalid workout choice.");
            }

            double[] caloriesHistory = {200.5, 250.0, 180.5, 400.0, 220.0};
            System.out.println("\n----- HISTORICAL CALORIES HISTORY -----");
            for (int j = 0; j < caloriesHistory.length; j++) {
                String burnType = (caloriesHistory[j] >= 250) ? "High calorie burn" : "Normal calorie burn";
                System.out.printf("Workout %d: %.1f kcal - %s%n", (j + 1), caloriesHistory[j], burnType);
            }

        } catch (InputMismatchException e) {
            System.out.println("\n❌ Error: Invalid numeric input format typed into terminal.");
        } finally {
            sc.close();
        }

        System.out.println("\n=================================");
        System.out.println(" Thank you for using the tracker!");
        System.out.println("=================================");
    }
}
