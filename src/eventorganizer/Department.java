package eventorganizer;

public enum Department {
    BAIT("Business Analytics and Information Technology"),
    CS("Computer Science"),
    EE("Electrical Engineering"),
    ITI("Information Technology and Informatics"),
    MATH("Mathematics");

    private String name;

    private Department(String name) {this.name = name;}

    public String getName() { return name; }

    @Override
    public String toString() { return name; }



}
