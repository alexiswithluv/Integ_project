package edu.institution;

import java.util.ArrayList;
import java.util.List;

public class EducationalInstitution {
    private String name;
    private String location;
    private List<String> courses;
    private String schoolYearStart;
    private String schoolYearEnd;

    public EducationalInstitution(String name, String location, String schoolYearStart, String schoolYearEnd) {
        this.name = name;
        this.location = location;
        this.courses = new ArrayList<>();
        this.schoolYearStart = schoolYearStart;
        this.schoolYearEnd = schoolYearEnd;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getCourses() {
        return courses;
    }

    // Methods to add and remove courses
    public void addCourse(String course) {
        this.courses.add(course);
    }

    public void removeCourse(String course) {
        this.courses.remove(course);
    }

    public String getSchoolYearStart() {
        return schoolYearStart;
    }

    public void setSchoolYearStart(String schoolYearStart) {
        this.schoolYearStart = schoolYearStart;
    }

    public String getSchoolYearEnd() {
        return schoolYearEnd;
    }

    public void setSchoolYearEnd(String schoolYearEnd) {
        this.schoolYearEnd = schoolYearEnd;
    }

    // Method to print the details of the institution
    public void printDetails() {
    	System.out.println("\n------------------------");
    	System.out.println("\nName: " + name);
        System.out.println("Location: " + location);
        System.out.println("Courses: " + String.join(", ", courses));
        System.out.println("School Year: " + schoolYearStart + " to " + schoolYearEnd);
        System.out.println("\n------------------------");
    }
}
