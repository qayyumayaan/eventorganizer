package eventorganizer;

/**
 * Department enum for representing various academic departments.
 *
 * @author Ayaan Qayyum
 */
public enum Department {
    /**
     * Business Analytics and Information Technology department.
     */
    BAIT("Business Analytics and Information Technology"),

    /**
     * Computer Science department.
     */
    CS("Computer Science"),

    /**
     * Electrical Engineering department.
     */
    EE("Electrical Engineering"),

    /**
     * Information Technology and Informatics department.
     */
    ITI("Information Technology and Informatics"),

    /**
     * Mathematics department.
     */
    MATH("Mathematics");

    private String name;

    /**
     * Private constructor for Department.
     *
     * @param name The full name of the department.
     * @author Ayaan Qayyum
     */
    private Department(String name) {this.name = name;}

    /**
     * Gets the name of the department.
     *
     * @return The full name of the department.
     * @author Ayaan Qayyum
     */
    public String getName() { return name; }

    /**
     * String representation of the Department.
     *
     * @return The full name of the department.
     * @author Ayaan Qayyum
     */
    @Override
    public String toString() { return name; }
}
