import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }
}

public class StudentGradingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        
        System.out.println("=== Student Grading System ===");
        
        while (true) {
            System.out.print("Enter student name (or type 'exit' to finish): ");
            String name = scanner.nextLine();
            
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            
            System.out.print("Enter score for " + name + ": ");
            double score = -1;
            
            // Input validation for scores
            while (score < 0 || score > 100) {
                try {
                    score = Double.parseDouble(scanner.nextLine());
                    if (score < 0 || score > 100) {
                        System.out.print("Invalid score. Please enter a value between 0 and 100: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Please enter a numeric score: ");
                }
            }
            
            students.add(new Student(name, score));
            System.out.println("Student added successfully!\n");
        }
        
        // Check if any data was entered
        if (students.isEmpty()) {
            System.out.println("No student data recorded.");
            scanner.close();
            return;
        }
        
        // Calculate Statistics
        double total = 0;
        double highest = students.get(0).score;
        double lowest = students.get(0).score;
        
        for (Student s : students) {
            total += s.score;
            if (s.score > highest) highest = s.score;
            if (s.score < lowest) lowest = s.score;
        }
        
        double average = total / students.size();
        
        // Display Summary Report
        System.out.println("\n=================================");
        System.out.println("         SUMMARY REPORT          ");
        System.out.println("=================================");
        System.out.printf("%-20s | %-10s\n", "Student Name", "Score");
        System.out.println("---------------------------------");
        
        for (Student s : students) {
            System.out.printf("%-20s | %-10.2f\n", s.name, s.score);
        }
        
        System.out.println("---------------------------------");
        System.out.printf("Total Students : %d\n", students.size());
        System.out.printf("Average Score  : %.2f\n", average);
        System.out.printf("Highest Score  : %.2f\n", highest);
        System.out.printf("Lowest Score   : %.2f\n", lowest);
        System.out.println("=================================");
        
        scanner.close();
    }
}
