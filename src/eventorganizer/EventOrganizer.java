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

    /**
     * Handles command R.
     * @author Ayaan Qayyum
     */
    public void caseRemove() {
        if(params.length != 4) return;

        String dateString = params[1];
        String startTimeString = params[2].toUpperCase();
        String locationString = params[3].toUpperCase();

        if (!dateIsValid(dateString)) return;
        if (!startTimeIsValid(startTimeString)) return;
        if (!locationIsValid(locationString)) return;


        Event event = new Event(date, startTime, location);
        if (eventCalendar.remove(event)) {
            System.out.println("Event has been removed from the calendar!");
        } else {
            System.out.println("Cannot remove; event is not in the calendar!");
        }

    }

    private boolean dateChecker(String dateString) {
        int count = 0;
        for (char c : dateString.toCharArray()) {
            if (c == '/') {
                count++;
            }
        }
        return count == 2;
    }

    private boolean dateIsValid(String dateString) {

        try {
            if (dateChecker(dateString)) {
                System.out.println(date + ": Invalid calendar date!");
                return false;
            }

            date = new Date(dateString);

            if (!date.isValid()) {
                System.out.println(date + ": Invalid calendar date!");
                return false;
            }
            if (!date.isTodayOrFuture()) {
                System.out.println(date + ": Event date must be a future date!");
                return false;
            }
            if (!date.isWithinSixMonths()) {
                System.out.println(date + ": Event date must be within 6 months!");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println(dateString + ": Invalid calendar date!");
            return false;
        }
    }

    private boolean startTimeIsValid(String startTimeString) {
        try {
            startTime = Timeslot.valueOf(startTimeString);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid time slot!");
            return false;
        }
    }

    private boolean locationIsValid(String locationString) {
        try {
            location = Location.valueOf(locationString);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid location!");
            return false;
        }
    }


    private boolean departmentIsValid(String departmentString) {
        try {
            department = Department.valueOf(departmentString);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid contact information!");
            return false;
        }
    }


    private boolean durationIsValid(String durationString) {
        try {
            duration = Integer.parseInt(durationString);
            if (duration < 30 || duration > 120) {
                System.out.println("Event duration must be at least 30 minutes and at most 120 minutes");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Event duration must be at least 30 minutes and at most 120 minutes");
            return false;
        }
    }



    private void casePrint() {
        if (params.length != 1) return;
        if (eventCalendar.getNumEvents() == 0) {
            System.out.println("Event calendar is empty!");
            return;
        }
        System.out.println("* Event calendar *");
        eventCalendar.print();
        System.out.println("* end of event calendar *");
    }

    private void casePrintByDate() {
        if (params.length != 1) return;
        if (eventCalendar.getNumEvents() == 0) {
            System.out.println("Event calendar is empty!");
            return;
        }
        System.out.println("* Event calendar by event date and start time *");
        eventCalendar.printByDate();
        System.out.println("* end of event calendar *");
    }
}
