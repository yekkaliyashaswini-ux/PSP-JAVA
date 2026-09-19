import java.util.Scanner;

class PersonalFitnessTracker1 {

    static void displayWorkout(String name, int age, double weight,
                               String workout, int duration, double calories) {

        System.out.println("\n----- WORKOUT DETAILS -----");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Workout: " + workout);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Calories Burned: " + calories + " kcal");
    }

    
    static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    
    static void fitnessStatus(int duration, double calories) {

        if (duration >= 30 && calories >= 200) {
            System.out.println("Fitness Status: Excellent workout!");
        }
        else if (duration >= 20 || calories >= 150) {
            System.out.println("Fitness Status: Good workout!");
        }
        else {
            System.out.println("Fitness Status: Try to exercise more.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       
        String name;
        int age;
        double weight;
        double height;
        int duration;
        double calories;

        System.out.println("=================================");
        System.out.println(" PERSONAL FITNESS & WORKOUT TRACKER");
        System.out.println("=================================");

        
        System.out.print("Enter your name: ");
        name = sc.nextLine();

        System.out.print("Enter your age: ");
        age = sc.nextInt();

        System.out.print("Enter your weight in kg: ");
        weight = sc.nextDouble();

        System.out.print("Enter your height in meters: ");
        height = sc.nextDouble();

        System.out.print("Enter workout duration in minutes: ");
        duration = sc.nextInt();

        System.out.print("Enter calories burned: ");
        calories = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter workout name: ");
        String workout = sc.nextLine();

       

        int totalMinutes = duration + 10;     
        double remainingCalories = 500 - calories;

        boolean isAdult = age >= 18;          
        boolean longWorkout = duration >= 30;

        
        displayWorkout(name, age, weight, workout, duration, calories);

        
        double bmi = calculateBMI(weight, height);

        System.out.printf("BMI: %.2f%n", bmi);

        
        fitnessStatus(duration, calories);

        System.out.println("\n----- OPERATOR RESULTS -----");
        System.out.println("Workout duration + 10 = " + totalMinutes);
        System.out.println("Calories remaining from 500 = " + remainingCalories);
        System.out.println("Age 18 or above: " + isAdult);
        System.out.println("Workout 30 minutes or more: " + longWorkout);


        
        System.out.println("\n----- WEEKLY WORKOUT ARRAY -----");

        int[] weeklyMinutes = {30, 45, 20, 60, 35, 40, 50};

        System.out.println("Weekly workout minutes:");

        for (int i = 0; i < weeklyMinutes.length; i++) {
            System.out.println("Day " + (i + 1) +
                               ": " + weeklyMinutes[i] + " minutes");
        }


        
        System.out.println("\nUsing Enhanced For Loop:");

        int total = 0;

        for (int minutes : weeklyMinutes) {
            System.out.println(minutes + " minutes");
            total = total + minutes;
        }

        System.out.println("Total weekly workout minutes: " + total);


        

        int i = 0;

        while (i < weeklyMinutes.length) {
            System.out.println("Day " + (i + 1) +
                               ": " + weeklyMinutes[i] + " minutes");
            i++;
        }



        int day = 0;

        do {
            System.out.println("Checking workout for Day " + (day + 1));
            day++;
        } while (day < weeklyMinutes.length);



        if (total >= 250) {
            System.out.println("You achieved more than 250 workout minutes!");
        }


        if (bmi < 25) {
            System.out.println("BMI is below 25.");
        }
        else {
            System.out.println("BMI is 25 or above.");
        }


        System.out.println("\n----- WORKOUT MENU -----");

        System.out.println("1. Running");
        System.out.println("2. Walking");
        System.out.println("3. Cycling");
        System.out.println("4. Swimming");

        System.out.print("Choose workout type: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.println("Selected: Running");
                break;

            case 2:
                System.out.println("Selected: Walking");
                break;

            case 3:
                System.out.println("Selected: Cycling");
                break;

            case 4:
                System.out.println("Selected: Swimming");
                break;

            default:
                System.out.println("Invalid workout choice.");
        }



        double[] caloriesBurned = {200.5, 250.0, 180.5, 400.0, 220.0};

        System.out.println("\n----- CALORIES  -----");

        for (int j = 0; j < caloriesBurned.length; j++) {

            if (caloriesBurned[j] >= 250) {
                System.out.println(
                    "Workout " + (j + 1) +
                    ": " + caloriesBurned[j] +
                    " kcal - High calorie burn"
                );
            }
            else {
                System.out.println(
                    "Workout " + (j + 1) +
                    ": " + caloriesBurned[j] +
                    " kcal - Normal calorie burn"
                );
            }
        }

        sc.close();

        System.out.println("\n=================================");
        System.out.println(" Thank you for using the tracker!");
        System.out.println("=================================");
    }
}