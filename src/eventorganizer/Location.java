package eventorganizer;

public enum Location {

    ARC103("Allison Road Classroom", "Busch"),
    HLL114("Hill Center", "Busch"),
    AB2225("Academic Building", "College Avenue"),
    MU302("Murray Hall", "College Avenue"),
    BE_AUD("Beck Hall", "Livingston"),
    TIL232("Tillett Hall", "Livingston");

    private String buildingName;
    private String campus;

    Location(String buildingName, String campus) {
        this.buildingName = buildingName;
        this.campus = campus;
    }

    public String getBuildingName() { return buildingName; }

    public String getCampus() { return campus; }

    @Override
    public String toString() { return this.name() + " (" + buildingName + ", " + campus + ")";}



}
