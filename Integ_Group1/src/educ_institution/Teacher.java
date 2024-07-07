package educ_institution;

/*
 * The Teacher class extends the Person class and includes String department exclusive to teachers.
 */

public class Teacher extends Person {
    private String department;
    
    /**
     * Constructing a new Teacher with the specified ID, name, and department.
     */

    public Teacher(String id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    /*Returns the department of the teacher*/
    public String getDepartment() {
        return department;
    }

    @Override
    public void displayDetails() {
        System.out.println("Teacher [" + super.toString() + ", Department: " + department + "]");
    }
}
