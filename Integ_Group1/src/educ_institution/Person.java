package educ_institution;

/*
 * The Person abstract class represents a person with an ID and a name.
 * It implements the PersonOperations interface.
 */

public abstract class Person implements PersonOperations {
    private String id;
    private String name;

    /*
     * Constructing a new Person with the specified ID and name.
     */
    
    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }
    /*Returns the id of the person*/
    public String getId() {
        return id;
    }

    /*Returns the name of the person*/
    public String getName() {
        return name;
    }

}
