package eventorganizer;

/**
 * Represents an event with attributes such as date, start time, location, contact, and duration.
 * Authors: Ayaan and Mychal
 */
public class Event implements Comparable<Event> {

    /**
     * The date of the event.
     */
    private final Date date;

    /**
     * The start time of the event.
     */
    private final Timeslot startTime;

    /**
     * The location of the event.
     */
    private final Location location;

    /**
     * The contact associated with the event.
     */
    private Contact contact;

    /**
     * The duration of the event in minutes.
     */
    private int duration;

    /**
     * Full constructor for Event.
     * @param date Event date
     * @param startTime Event start time
     * @param location Event location
     * @param contact Event contact
     * @param duration Event duration in minutes
     * @author Ayaan Qayyum
     */
    public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration) {
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }

    /**
     * Partial constructor for Event.
     * @param date Event date
     * @param startTime Event start time
     * @param location Event location
     * @author Ayaan Qayyum
     */
    public Event(Date date, Timeslot startTime, Location location) {
        this.date = date;
        this.startTime = startTime;
        this.location = location;
    }

    /**
     * Compares this event with another event.
     * @param otherEvent Event to compare to
     * @return Comparison result
     * @author Ayaan Qayyum
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Event event)) return false;

        return date.equals(event.date) &&
                startTime.equals(event.startTime) &&
                location.equals(event.location);
    }

    /**
     * Checks if this event is equal to another object.
     * @param obj Object to compare to
     * @return true if equal, false otherwise
     * @author Ayaan Qayyum
     */
    @Override
    public int compareTo(Event otherEvent) {
        int dateComparison = this.date.compareTo(otherEvent.date);
        if (dateComparison != 0) {
            return dateComparison;
        }
        return this.startTime.compareTo(otherEvent.startTime);
    }

    /**
     * Returns string representation of this event.
     * @return Event as a string
     * @author Ayaan Qayyum
     */
    @Override
    public String toString() {

        return "[Event Date: " + getDate().toString() + "] " +
                "[Start: " + getStartTime().toString() + "] " +
                "[End: " + getEndTime() + "] " +
                "@" + getLocation().name() + " (" +
                getLocation().getBuildingName() + ", " + getLocation().getCampus() + ") " +
                "[Contact: " + getContact().getDepartment() + ", " + getContact().getEmail() + "]";

    }

    /**
     * Gets the date of the event.
     * @return Event date
     * @author Ayaan Qayyum
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Gets the start time of the event.
     * @return Event start time
     * @author Ayaan Qayyum
     */
    public Timeslot getStartTime() {
        return this.startTime;
    }

    /**
     * Gets the location of the event.
     * @return Event location
     * @author Ayaan Qayyum
     */
    public Location getLocation() {
        return this.location;
    }

    /**
     * Gets the contact of the event.
     * @return Event contact
     * @author Ayaan Qayyum
     */
    public Contact getContact() {
        return this.contact;
    }

    /**
     * Gets the end time of the event.
     * @return Event end time
     * @author Ayaan Qayyum
     */
    public String getEndTime() {
        return this.startTime.getEnd(duration);
    }

    /**
     * Gets the department associated with the event.
     * @return Event department
     * @author Ayaan Qayyum
     */
    public Department getDepartment() {
        return this.getContact().getDepartment();
    }
}