import java.util.Scanner;

public class ResultManager {
    private Student[] students = new Student[100];
    private int count = 0;

    public void addStudent() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            int[] marks = new int[3];
            for (int i = 0; i < 3; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                marks[i] = sc.nextInt();
            }

            Student s = new Student(roll, name, marks);
            s.validateMarks();
            students[count++] = s;
            System.out.println("Student added successfully.");
        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Input Error");
        } finally {
            System.out.println("Returning to main menu...");
        }
    }

    public void showStudentDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Roll Number to search: ");
        int r = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (students[i].getRollNumber() == r) {
                students[i].displayResult();
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void mainMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===== Student Result Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Show Student Details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int c = sc.nextInt();

            if (c == 1) addStudent();
            else if (c == 2) showStudentDetails();
            else if (c == 3) {
                System.out.println("Exiting program. Thank you!");
                break;
            } else System.out.println("Invalid choice.");
        }
    }

    public static void main(String[] args) {
        ResultManager r = new ResultManager();
        r.mainMenu();
    }
}
