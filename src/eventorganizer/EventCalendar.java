package eventorganizer;

/**
 * Manages a dynamic array of Event objects.
 *
 * @author Ayaan Qayyum
 */

public class EventCalendar {

    private Event[] events;
    private int numEvents;

    private static final int INITIAL_SIZE = 4;
    private static final int GROW_SIZE = 4;
    private static final int NOT_FOUND = -1;

    /**
     * Constructs an empty EventCalendar.
     * @author Ayaan Qayyum
     */
    public EventCalendar() {
        events = new Event[INITIAL_SIZE];
        numEvents = 0;
    }

    /**
     * Returns the current number of Events.
     * @return The current number of Events.
     * @author Ayaan Qayyum
     */
    public int getNumEvents() { return numEvents; }


    /**
     * Finds the index of an Event.
     * @param event The Event to find.
     * @return The index or NOT_FOUND if not found.
     * @author Ayaan Qayyum
     */
    private int find(Event event) {
        for (int i = 0; i < numEvents; i++) {
            if (events[i].equals(event))
                return i;
        }
        return NOT_FOUND;
    }

    /**
     * Expands the internal array size.
     * @author Ayaan Qayyum
     */
    private void grow() {
        Event[] eventsNew = new Event[events.length + GROW_SIZE];
        for (int i = 0; i < events.length; i++) {
            eventsNew[i] = events[i];
        }
        events = eventsNew;
    }

    /**
     * Checks if the Event exists.
     *
     * @param event The Event to check.
     * @return True if it exists, false otherwise.
     * @author Ayaan Qayyum
     */
    public boolean contains(Event event) { return find(event) != NOT_FOUND; }

    /**
     * Adds an Event.
     *
     * @param event The Event to add.
     * @return True if added, false otherwise.
     * @author Ayaan Qayyum
     */
    public boolean add(Event event) {
        if (contains(event)) return false;
        if (numEvents == events.length) grow();
        events[numEvents++] = event;
        return true;
    }


    /**
     * Removes an Event.
     *
     * @param event The Event to remove.
     * @return True if removed, false otherwise.
     * @author Ayaan Qayyum
     */
    public boolean remove(Event event) {
        if (!contains(event)) return false;
        int index = find(event);
        for (int i = index; i < events.length - 1; i++) events[i] = events[i + 1];
        events[events.length - 1] = null;
        numEvents--;
        return true;
    }

    public void print() {
        for (int i = 0; i < numEvents; i++) System.out.println(events[i]);
    }

    /**
     * Prints Events sorted by date.
     * @author Ayaan Qayyum
     */
    public void printByDate() {
        for (int i = 0; i < numEvents; i++) {
            for (int j = 0; j < numEvents - 1; j++) {
                if (events[j].compareTo(events[j + 1]) > 0) {
                    Event temp = events[j];
                    events[j] = events[j+1];
                    events[j+1] = temp;
                }
            }
        }
        print();
    }

    /**
     * Prints Events sorted by campus and building and room.
     * @author Ayaan Qayyum
     */
    public void printByCampus() {

        for (int i = 0; i < numEvents; i++) {
            for (int j = 0; j < numEvents - 1; j++) {
                if (events[j].getDate().equals(events[j + 1].getDate())) {
                    Event temp = events[j];
                    events[j] = events[j + 1];
                    events[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < numEvents; i++) {
            for (int j = 0; j < numEvents - 1; j++) {
                if (events[j].getLocation().getCampus().compareTo(events[j + 1].getLocation().getCampus()) > 0) {
                    Event temp = events[j];
                    events[j] = events[j + 1];
                    events[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < numEvents; i++) {
            for (int j = 0; j < numEvents - 1; j++) {
                if (events[j].getLocation().getCampus().equals(events[j + 1].getLocation().getCampus()) &&
                        events[j].getLocation().getBuildingName().compareTo(events[j + 1].getLocation().getBuildingName()) > 0) {
                    Event temp = events[j];
                    events[j] = events[j + 1];
                    events[j + 1] = temp;
                }
            }
        }

        print();
    }

    /**
     * Prints Events sorted by department.
     * @author Ayaan Qayyum
     */
    public void printByDepartment() {
        for (int i = 0; i < numEvents - 1; i++) {
            for (int j = 0; j < numEvents - i - 1; j++) {
                if (events[j].getContact().getDepartment().getName().compareTo(events[j + 1].getContact().getDepartment().getName()) > 0) {
                    Event temp = events[j];
                    events[j] = events[j + 1];
                    events[j + 1] = temp;
                }
            }
        }
        print();
    }
}
