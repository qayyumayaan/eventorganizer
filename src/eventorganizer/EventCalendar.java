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


}
