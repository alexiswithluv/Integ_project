package educ_institution;

public class Student extends Person {
    private String major;

    public Student(String id, String name, String major) {
        super(id, name);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    
    public void displayDetails() {
        System.out.println("Student [" + super.toString() + ", Major: " + major + "]");
    }
}

