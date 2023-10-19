package eventorganizer;

public class EventCalendar {

    private Event[] events;
    private int numEvents;

    private static final int INITIAL_SIZE = 4;
    private static final int GROW_SIZE = 4;
    private static final int NOT_FOUND = -1;

    public EventCalendar() {
        events = new Event[INITIAL_SIZE];
        numEvents = 0;
    }

    public int getNumEvents() { return numEvents; }

    private int find(Event event) {
        for (int i = 0; i < numEvents; i++) {
            if (events[i].equals(event))
                return i;
        }
        return NOT_FOUND;
    }

    private void grow() {
        Event[] eventsNew = new Event[events.length + GROW_SIZE];
        for (int i = 0; i < events.length; i++) {
            eventsNew[i] = events[i];
        }
        events = eventsNew;
    }

    public boolean contains(Event event) { return find(event) != NOT_FOUND;}

    public boolean add(Event event) {
        if (contains(event)) return false;
        if (numEvents == events.length) grow();
        events[numEvents++] = event;
        return true;
    }

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

    public void printByDate() {
        for (int i = 0; i < numEvents; i++) {
            for (int j = 0; j < numEvents - 1; j++) {
                if (events[j].compareTo(events[j + 1] > 0)) {
                    Event temp = events[j];
                    events[j] = events[j+1];
                    events[j+1] = temp;
                }
            }
        }
        print();
    }

    public void printByCampus() {
    }
    public void printByDepartment() {
    }
}
