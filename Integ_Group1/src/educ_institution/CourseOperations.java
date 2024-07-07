package educ_institution;

public interface CourseOperations {
	
    void addStudent(Student student); /* adding a student to the course */
    void removeStudent(Student student);
    void displayCourseDetails(); /* Displays the details of the course, such as course name, 
     * course code, list of enrolled students */
}

