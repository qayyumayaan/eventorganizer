package eventorganizer;
/**
 * Timeslot class for representing different times of day for scheduling events.
 *
 * @author Ayaan Qayyum
 */
public enum Timeslot {
    /**
     * Enumerated time slots.
     */

    MORNING(10, 30),
    AFTERNOON(14,00),
    EVENING(18,30);

    private int hours;
    private int minutes;

    private static final int NOON = 12;
    private static final int MINUTES_PER_HOUR = 60;


    /**
     * Private constructor for Timeslot.
     *
     * @param hours The starting hour.
     * @param minutes The starting minute.
     * @author Ayaan Qayyum
     */
    Timeslot(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    /**
     * Gets the hour component of the time slot.
     *
     * @return The starting hour.
     * @author Ayaan Qayyum
     */
    public int getHours() { return hours; }

    /**
     * Gets the minute component of the time slot.
     *
     * @return The starting minute.
     * @author Ayaan Qayyum
     */
    public int getMinutes() { return minutes; }


    /**
     * String representation of the Timeslot.
     *
     * @return A formatted string.
     * @author Ayaan Qayyum
     */
    public String toString() {
        if (hours < NOON) return String.format("%d:%02dam", hours, minutes);
        else if (hours == NOON) return String.format("%d:%02dpm", hours, minutes);
        else return String.format("%d:%02dpm", hours > NOON ? hours - 12 : hours, minutes);
    }

    /**
     * String representation of the Timeslot with duration.
     *
     * @param duration Duration in minutes to add.
     * @return A formatted string.
     * @author Ayaan Qayyum
     */
    public String toString(int duration) {
        int time = hours * MINUTES_PER_HOUR + minutes + duration;
        int endHours = time / MINUTES_PER_HOUR;
        int endMinutes = time - endHours * MINUTES_PER_HOUR;

        if (endHours < NOON) return String.format("%d:%02dam", endHours, endMinutes);
        else if (endHours == NOON) return String.format("%d:%02dpm", endHours, endMinutes);
        else return String.format("%d:%02dpm", endHours > NOON ? endHours - 12 : endHours, endMinutes);
    }

    public String getEnd(int duration) {
        int totalMinutes = this.hours * MINUTES_PER_HOUR + this.minutes + duration;
        int endHours = totalMinutes / MINUTES_PER_HOUR;
        int endMinutes = totalMinutes % MINUTES_PER_HOUR;

        if (endHours >= 24) endHours -= 24;

        if (endHours < NOON) {
            return String.format("%d:%02dam", endHours, endMinutes);
        } else if (endHours == NOON) {
            return String.format("%d:%02dpm", endHours, endMinutes);
        } else {
            return String.format("%d:%02dpm", endHours > NOON ? endHours - 12 : endHours, endMinutes);
        }
    }


}
