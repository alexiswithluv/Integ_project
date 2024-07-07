package educ_institution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Main class implements a command-line interface for managing students, teachers, and courses in an educational institution.
 */
public class Main {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();    // List to store all people (students and teachers)
        List<Course> courses = new ArrayList<>();    // List to store all courses
        Scanner scanner = new Scanner(System.in);    // Scanner object to read user input
        int choice;    // Variable to store user's menu choice

        // Main menu loop
        do {
            // Display menu options
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Create Course");
            System.out.println("4. Enroll Student in Course");
            System.out.println("5. Remove Student from Course");
            System.out.println("6. Display Course Details");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();    // Read user input for menu choice
            scanner.nextLine();    // Consume newline character

            // Switch case based on user's choice
            switch (choice) {
                case 1:
                    // Add Student
                    System.out.print("Enter the number of students to add: ");
                    int numStudents = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Loop to add multiple students
                    for (int i = 0; i < numStudents; i++) {
                        System.out.println("\n-----------------------");
                        System.out.println((i + 1) + ".");
                        System.out.print("Enter Student ID: ");
                        String studentId = scanner.nextLine();
                        System.out.print("Enter Student Name: ");
                        String studentName = scanner.nextLine();
                        System.out.print("Enter Student Major: ");
                        String studentMajor = scanner.nextLine();
                        // Create and add new Student object to people list
                        people.add(new Student(studentId, studentName, studentMajor));
                    }
                    System.out.println("-----------------------\n");
                    break;
                case 2:
                    // Add Teacher
                    System.out.print("Enter the number of teachers to add: ");
                    int numTeachers = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Loop to add multiple teachers
                    for (int i = 0; i < numTeachers; i++) {
                        System.out.println("\n-----------------------");
                        System.out.println((i + 1) + ".");
                        System.out.print("Enter Teacher ID: ");
                        String teacherId = scanner.nextLine();
                        System.out.print("Enter Teacher Name: ");
                        String teacherName = scanner.nextLine();
                        System.out.print("Enter Teacher Department: ");
                        String teacherDepartment = scanner.nextLine();
                        // Create and add new Teacher object to people list
                        people.add(new Teacher(teacherId, teacherName, teacherDepartment));
                    }
                    System.out.println("-----------------------\n");
                    break;
                case 3:
                    // Create Course
                    System.out.print("Enter the number of courses to add: ");
                    int numCourses = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Loop to add multiple courses
                    for (int i = 0; i < numCourses; i++) {
                        System.out.println("\n-----------------------");
                        System.out.println((i + 1) + ".");
                        System.out.print("Enter Course ID: ");
                        String courseId = scanner.nextLine();
                        System.out.print("Enter Course Name: ");
                        String courseName = scanner.nextLine();
                        System.out.print("Enter Teacher ID for the Course: ");
                        String courseTeacherId = scanner.nextLine();

                        // Find the teacher object based on provided ID
                        Teacher courseTeacher = null;
                        for (Person person : people) {
                            if (person instanceof Teacher && person.getId().equals(courseTeacherId)) {
                                courseTeacher = (Teacher) person;
                                break;
                            }
                        }

                        // Create and add new Course object to courses list if teacher found
                        if (courseTeacher != null) {
                            courses.add(new Course(courseId, courseName, courseTeacher));
                        } else {
                            System.out.println("Teacher not found.");
                        }
                    }
                    System.out.println("-----------------------\n");
                    break;
                case 4:
                    // Enroll Student in Course
                    System.out.print("Enter the number of students to enroll: ");
                    int numEnroll = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Loop to enroll multiple students in a course
                    for (int i = 0; i < numEnroll; i++) {
                        System.out.println("\n-----------------------");
                        System.out.println((i + 1) + ".");
                        System.out.print("Enter Course ID: ");
                        String enrollCourseId = scanner.nextLine();
                        System.out.print("Enter Student ID: ");
                        String enrollStudentId = scanner.nextLine();

                        // Find the course object based on provided ID
                        Course enrollCourse = null;
                        for (Course course : courses) {
                            if (course.getCourseId().equals(enrollCourseId)) {
                                enrollCourse = course;
                                break;
                            }
                        }

                        // Find the student object based on provided ID
                        Student enrollStudent = null;
                        for (Person person : people) {
                            if (person instanceof Student && person.getId().equals(enrollStudentId)) {
                                enrollStudent = (Student) person;
                                break;
                            }
                        }

                        // Enroll student in course if both course and student found
                        if (enrollCourse != null && enrollStudent != null) {
                            enrollCourse.addStudent(enrollStudent);
                        } else {
                            System.out.println("Course or Student not found.");
                        }
                    }
                    System.out.println("-----------------------\n");
                    break;
                case 5:
                    // Remove Student from Course
                    System.out.print("Enter Course ID from which to remove student: ");
                    String removeCourseId = scanner.nextLine();
                    System.out.print("Enter Student ID to remove: ");
                    String removeStudentId = scanner.nextLine();

                    // Find the course object based on provided ID
                    Course removeCourse = null;
                    for (Course course : courses) {
                        if (course.getCourseId().equals(removeCourseId)) {
                            removeCourse = course;
                            break;
                        }
                    }

                    // Find the student object based on provided ID
                    Student removeStudent = null;
                    for (Person person : people) {
                        if (person instanceof Student && person.getId().equals(removeStudentId)) {
                            removeStudent = (Student) person;
                            break;
                        }
                    }

                    // Remove student from course if both course and student found
                    if (removeCourse != null && removeStudent != null) {
                        removeCourse.removeStudent(removeStudent);
                        System.out.println("Student removed from the course.");
                    } else {
                        System.out.println("Course or Student not found.");
                    }
                    System.out.println("-----------------------\n");
                    break;
                case 6:
                    // Display Course Details
                    System.out.println("\n-----------------------");
                    System.out.print("Enter Course ID to View Details: ");
                    String viewCourseId = scanner.nextLine();

                    // Find the course object based on provided ID and display its details
                    Course viewCourse = null;
                    for (Course course : courses) {
                        if (course.getCourseId().equals(viewCourseId)) {
                            viewCourse = course;
                            break;
                        }
                    }

                    // Display course details if found, otherwise display error message
                    if (viewCourse != null) {
                        viewCourse.displayCourseDetails();
                    } else {
                        System.out.println("Course not found.");
                    }
                    System.out.println("-----------------------\n");
                    break;
                case 7:
                    // Exit Program
                    System.out.println("Exiting...");
                    break;
                default:
                    // Invalid Choice
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        } while (choice != 7);    // Continue loop until user chooses to exit

        scanner.close();    // Close scanner object to release resources
    }
}
