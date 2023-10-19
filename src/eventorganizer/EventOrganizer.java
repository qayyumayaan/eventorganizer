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
}
