package com.springcore.student.enrollment.system;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan(basePackages = "com.springcore.student.enrollment.system")

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("student_enrollment_system.xml");

        StudentService studentService = context.getBean(StudentService.class);


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Retrieve Student by ID");
            System.out.println("3. List All Students");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter courses (comma-separated): ");
                    String coursesInput = scanner.nextLine();
                    String[] courses = coursesInput.split(",");

                    Student newStudent = new Student(id, name, new ArrayList<>());
                    newStudent.setCourses(List.of(courses));
                    studentService.addStudent(newStudent);

                    break;
                case 2:
                    System.out.print("Enter student ID to retrieve: ");
                    int retrieveId = scanner.nextInt();
                    scanner.nextLine();

                    Student retrievedStudent = studentService.getStudentById(retrieveId);

                    if (retrievedStudent != null) {
                        System.out.println("Student ID: " + retrievedStudent.getId());
                        System.out.println("Name: " + retrievedStudent.getName());
                        System.out.println("Courses: " + retrievedStudent.getCourses());
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;
                case 3:
                    List<Student> students = studentService.getAllStudents();

                    if (students.isEmpty()) {
                        System.out.println("No students enrolled.");
                    } else {
                        for (Student s : students) {
                            System.out.println("Student ID: " + s.getId());
                            System.out.println("Name: " + s.getName());
                            System.out.println("Courses: " + s.getCourses());
                            System.out.println("---------------");
                        }
                    }

                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}
