package eventorganizer;

public class Contact {
    private Department department;
    private String email;

    public Contact(Department department, String email) {
        super();
        this.department = department;
        this.email = email;
    }

    public Department getDepartment() { return department; }

    public String getEmail() { return email; }

    public boolean isValid() {
        if (department == null) return false;
        if(email == null) return false;
        if(!email.contains("@")) return false;
        if (email.split("@").length != 2) return false;
        if(!email.split("@")[1].equals("rutgers.edu")) return false;
        return true;
    }

    @Override
    public String toString() { return department + ", " + email; }
}
