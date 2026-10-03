import java.util.Scanner;
public class WasteTargetChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the waste collected in kilograms: ");
        double wasteCollected = sc.nextDouble();
        
        double targetWaste = 100;

        if (wasteCollected >= targetWaste) {
            System.out.println("Collection Target Achieved");
        } else {
            System.out.println("More Waste Collection Required: ");
        }

        sc.close();
    }
}