package eventorganizer;

/**
 * Enumerates different locations where events can be held, including the building name and campus.
 * @author Ayaan Qayyum
 */
public enum Location {

    /**
     * Allison Road Classroom on Busch campus.
     * @author Ayaan Qayyum
     */
    ARC103("Allison Road Classroom", "Busch"),

    /**
     * Hill Center on Busch campus.
     * @author Ayaan Qayyum
     */
    HLL114("Hill Center", "Busch"),

    /**
     * Academic Building on College Avenue campus.
     * @author Ayaan Qayyum
     */
    AB2225("Academic Building", "College Avenue"),

    /**
     * Murray Hall on College Avenue campus.
     * @author Ayaan Qayyum
     */
    MU302("Murray Hall", "College Avenue"),

    /**
     * Beck Hall on Livingston campus.
     * @author Ayaan Qayyum
     */
    BE_AUD("Beck Hall", "Livingston"),

    /**
     * Tillett Hall on Livingston campus.
     * @author Ayaan Qayyum
     */
    TIL232("Tillett Hall", "Livingston");

    /**
     * The name of the building.
     * @author Ayaan Qayyum
     */
    private String buildingName;

    /**
     * The campus where the building is located.
     * @author Ayaan Qayyum
     */
    private String campus;

    /**
     * Constructor for Location enum.
     *
     * @param buildingName The name of the building
     * @param campus       The campus where the building is located
     * @author Ayaan Qayyum
     */
    Location(String buildingName, String campus) {
        this.buildingName = buildingName;
        this.campus = campus;
    }

    /**
     * Gets the name of the building.
     *
     * @return The building name
     * @author Ayaan Qayyum
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     * Gets the campus where the building is located.
     *
     * @return The campus name
     * @author Ayaan Qayyum
     */
    public String getCampus() {
        return campus;
    }

    /**
     * Returns the string representation of the enum.
     *
     * @return A string containing the enum name, building name, and campus
     * @author Ayaan Qayyum
     */
    @Override
    public String toString() {
        return this.name() + " (" + buildingName + ", " + campus + ")";
    }
}