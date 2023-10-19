package eventorganizer;
/**
 * Authors: Ayaan and Mychal
 */
public class Event implements Comparable<Event>{
    // Ayaan
    private Date date;
    private Timeslot startTime;
    private Location location;
    private Contact contact;
    private int duration;

    public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration){
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }

    public Event(Date date, Timeslot startTime, Location location) {
        this.date = date;
        this.startTime = startTime;
        this.location = location;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Event)) return false;

        Event event = (Event) obj;
        return date.equals(event.date) &&
                startTime.equals(event.startTime) &&
                location.equals(event.location);
    }

    @Override
    public int compareTo(Event otherEvent) {
        int dateComparison = this.date.compareTo(otherEvent.date);
        if (dateComparison != 0) {
            return dateComparison;
        }
        return this.startTime.compareTo(otherEvent.startTime);
    }


    public Date getDate() {
        return this.date;
    }

    public Timeslot getStartTime() {
        return this.startTime;
    }

    public Location getLocation() {
        return this.location;
    }

    public Contact getContact() {
        return this.contact;
    }


}
