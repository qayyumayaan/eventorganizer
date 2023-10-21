package eventorganizer;

/**
 * Represents a contact associated with an event, including department and email details.
 *
 * @author Ayaan Qayyum
 */
public class Contact {

    /**
     * The department associated with the contact.
     */
    private Department department;

    /**
     * The email of the contact.
     */
    private String email;

    /**
     * Constructor for Contact.
     *
     * @param department The department associated with the contact
     * @param email      The email of the contact
     */
    public Contact(Department department, String email) {
        super();
        this.department = department;
        this.email = email;
    }

    /**
     * Gets the department associated with the contact.
     *
     * @return The department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Gets the email of the contact.
     *
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Validates the email and department.
     *
     * @return true if valid, false otherwise
     */
    public boolean isValid() {
        if (department == null) return false;
        if(email == null) return false;
        if(!email.contains("@")) return false;
        if (email.split("@").length != 2) return false;
        if(!email.split("@")[1].equals("rutgers.edu")) return false;
        return true;
    }

    /**
     * Returns the string representation of the contact.
     *
     * @return A string containing the department and email
     */
    @Override
    public String toString() { return department + ", " + email; }
}
