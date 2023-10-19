package eventorganizer;

public enum Location {
    HLL114("Hill Center", "Busch"),
    ARC103("Allison Road Classroom", "Busch"),
    TIL232("Tillett Hall", "Livingston"),
    BE_AUD("Beck Hall", "Livingston"),
    AB2225("Academic Building", "College Avenue"),
    MU302("Murray Hall", "College Avenue");

    private String buildingName;
    private String campus;

    private Location(String buildingName, String campus) {
        this.buildingName = buildingName;
        this.campus = campus;
    }

    public String getBuildingName() { return buildingName; }

    public String getCampus() { return campus; }

    @Override
    public String toString() { return this.name() + " (" + buildingName + ", " + campus + ")";}



}
