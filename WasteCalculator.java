import java.util.Scanner;

public class WasteCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading waste from two collection points
        System.out.print("Enter waste collected at Point 1 (kg): ");
        double point1 = scanner.nextDouble();

        System.out.print("Enter waste collected at Point 2 (kg): ");
        double point2 = scanner.nextDouble();

        // Calling the method and storing the result
        double totalWaste = calculateTotalWaste(point1, point2);

        // Displaying the total waste collected
        System.out.println("Total waste collected from both points: " + totalWaste + " kg");

        scanner.close();
    }

    // Method to calculate total waste
    public static double calculateTotalWaste(double point1Waste, double point2Waste) {
        return point1Waste + point2Waste;
    }
}
