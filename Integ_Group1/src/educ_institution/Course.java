package educ_institution;

import java.util.ArrayList;
import java.util.List;

/*
* The Course class represents a course in an educational institution.
* It implements CourseOperations interface to provide operations for managing students enrolled in the course.
*/

public class Course implements CourseOperations {
    private String courseId; // Unique identifier for the course
    private String courseName; // Name of the course
    private Teacher teacher; // Assigned Teacher for that specific course
    private List<Student> students; // List of students enrolled in the course
    
    /*
     * Constructing a new Course object with course ID, course name, and teacher.
     */

    public Course(String courseId, String courseName, Teacher teacher) {
        this.courseId = courseId; 
        this.courseName = courseName;
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }

    public String getCourseId() {
        return courseId; /*Returns course id*/
    }

    public String getCourseName() {
        return courseName; /*Returns course name*/
    }

    public Teacher getTeacher() {
        return teacher; /*Returns teacher name*/
    }

    
    public void addStudent(Student student) {
        students.add(student); /*Adds a student in a course*/
    }

    
    public void removeStudent(Student student) {
        students.remove(student); /*Removes a student in a course*/
    }

    /*
     * Displays the details of the course, including its ID, name, teacher, and list of enrolled students.
     */
    public void displayCourseDetails() {
        System.out.println("\nCourse [ID: " + courseId + ", Name: " + courseName + "]");
        System.out.println("Teacher: " + teacher.getName());
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println("  " + student.getName() + " (" + student.getMajor() + ")");
        }
    }
}
