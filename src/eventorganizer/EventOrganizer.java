package eventorganizer;

import java.util.Objects;
import java.util.Scanner;

public class EventOrganizer {

    EventCalendar eventCalendar = new EventCalendar();
    Date date;
    Timeslot startTime;
    Location location;
    Department department;
    int duration;
    String command;
    String[] params;
    Scanner scanner = new Scanner(System.in);


    public void run() {
        System.out.println("Event Organizer running...");
        while (!Objects.equals(command, "Q")) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }
            params = input.split("\\s+");
            command = params[0];
            switch (command) {
                case "A" -> caseAdd();
                case "R" -> caseRemove();
                case "P" -> casePrint();
                case "PE" -> casePrintByDate();
                case "PC" -> casePrintByCampus();
                case "PD" -> casePrintByDepartment();
                case "Q" -> {
                    System.out.println("Event Organizer terminated.");
                    scanner.close();
                    return;
                }
                default -> System.out.println(command + "is an invalid command!");
            }
        }
    }


    /**
     * Handles command A.
     * @author Ayaan Qayyum
     */
    public void caseAdd() {
        if (params.length != 7) return;

        String dateString = params[1];
        String startTimeString = params[2].toUpperCase();
        String locationString = params[3].toUpperCase();
        String departmentString = params[4].toUpperCase();
        String email = params[5];
        String durationString = params[6];

        if (!dateIsValid(dateString)) return;
        if (!startTimeIsValid(startTimeString)) return;
        if (!locationIsValid(locationString)) return;
        if (!departmentIsValid(departmentString)) return;


        Contact contact = new Contact(department, email);
        if (!contact.isValid()) {
            System.out.println("Invalid contact information!");
            return;
        }
        int duration = 0;
        if (!durationIsValid(durationString)) return;

        Event event = new Event(date, startTime, location, contact, duration);
        if (eventCalendar.add(event)) {
            System.out.println("Event added to the calendar.");
        } else {
            System.out.println("The event is already on the calendar.");
        }
    }
}
