import java.util.Scanner;
public class Student {
    String studentName;
    double rollNumber;
    int marks;
    String courseName;
    int courseCredits;

    public Student(String studentName, double rollNumber, int marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }
    public double calculateFee() {
        double feePerCredit = 1500.0;
        return courseCredits * feePerCredit;
    }
    public boolean checkEligibity() {
        return marks >= 50; 
    }
    public double calculateScholarship() {
        if (marks >= 85) {
            return 0.2 * calculateFee(); 
        } else if (marks >= 70 && marks <= 85) {
            return 0.1 * calculateFee(); 
        } else {
            return 0.0; 
        }
    }
    public int calculateFinalFee() {
        double scholarshipAmount = calculateScholarship();
        return (int) (calculateFee() - scholarshipAmount);
    }

    public void displayDetails() {
        System.out.println("Student Details:");
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Total Fee: " + calculateFee());
        System.out.println("Scholarship Amount: " + calculateScholarship());
        System.out.println("Final Fee after Scholarship: " + calculateFinalFee());
        System.out.println("Eligibility: " + (checkEligibity() ? "Eligible for registration" : "Not Eligible for registraction"));
        
    }
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Roll Number: ");
            double rollNumber = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Course Name: ");
            String courseName = sc.nextLine();
            System.out.print("Enter Course Credits: ");
            int courseCredits = sc.nextInt();

            Student student = new Student(name, rollNumber, marks, courseName, courseCredits);

            if (student.checkEligibity()) {
                System.out.println("The student is eligible for the course.");
            } else {
                System.out.println("The student is not eligible for the course.");
            }

            student.displayDetails();

            sc.close();
        }
    }
}