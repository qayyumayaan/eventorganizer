package eventorganizer;

public class Timeslot {

    MORNING(10, 30),
    AFTERNOON(14,00),
    EVENING(18.30);

    private int hours;
    private int minutes;

    private static final int NOON = 12;
    private static final int MINUTES_PER_HOUR = 60;


    private Timeslot(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHours() { return hours; }

    public int getMinutes() { return minutes; }

    public String toString() {
        if (hours < NOON) return String.format("%d:%02dam", hours, minutes);
        else if (hours == NOON) return String.format("%d:%02dpm", hours, minutes);
        else return String.format("%d:%02dpm", hours, 12, minutes);
    }

    public String toString(int duration) {
        int time = hours * MINUTES_PER_HOUR + minutes + duration;
        int endHours = time / MINUTES_PER_HOUR;
        int endMinutes = time - endHours * MINUTES_PER_HOUR;

        if (endHours < NOON) return String.format("%d:%02dam", endHours, endMinutes);
        else if (endHours == NOON) return String.format("%d:%02dpm", endHours, endMinutes);
        else return String.format("%d:%02dpm", endHours, 12, endMinutes);
    }

}
