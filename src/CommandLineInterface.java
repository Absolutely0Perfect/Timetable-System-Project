import java.util.Objects;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
/**
*  <p>This class is the CLI used to display any inputs the user needs to input.
 * Inherited from the abstract View Class.</p>
*/
public class CommandLineInterface extends View {
    private final Scanner scanner;
    public final int WIDTH = 25;

    CommandLineInterface() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String selection(List<String[]> names){
        IO.println("Select a Module to display");

        for(int i = 0; i < names.size(); i++){
            IO.println(i + ":" + names.get(i)[0] + "-" + names.get(i)[1]);
        }
        int userChoice = scanner.nextInt();

        return names.get(userChoice)[0];
    }

    @Override
    public void displayTimetable(ModuleTimetable module) {
        List<TimeSlot> slots = module.getTimeSlots();
        String[] buffer = {"", "", "", "", ""};

        int currentDay = -1; // this is current PRINTING day e.g. the place where we stopped in the row printing
        boolean theRowPrinted = false;
        int previousTime = 0;
        int previousDay = 5; // this is the day last processed timeslot was in
        int time;
        int day;

        printEmptyRow();

        for (TimeSlot slot : slots) {
            time = slot.getStart() - 9; // offset so that 0 equals 9 am
            day = slot.getDay().toInt() - 1;

            for (int j = previousDay + 1; j <= 5 && (j < day || previousTime < time); j++) {// this part is to finish started rows
                appendEmptySlotToBuffer(buffer);

                if (j == 5) {
                    printBuffer(buffer);
                    theRowPrinted = false;
                    currentDay = -1;
                } else {
                    currentDay = j + 1;
                }
            }

            for (int j = previousTime + 1; j <= time - 1; j++) { // skip through rows without any info
                printEmptyRow();
            }

            if (!theRowPrinted) { // checks if we are in the middle of printing a row
                printRowBreak();
                theRowPrinted = true;
            }

            for (int j = Math.max(0, currentDay); j < day; j++) {// fills the row with info with empty slots in
                appendEmptySlotToBuffer(buffer);
            }

            appendSlotToBuffer(buffer, slot); // adds info to the row
            currentDay = day + 1;
            if (day == 5) {
                printBuffer(buffer);
                theRowPrinted = false;
                currentDay = -1;
            }

            previousTime = time;
            previousDay = day;
        } 
        // from here we just fill the rest of the timetable with empty slots 
        if(previousDay != 5){
            for(int j = previousDay + 1; j <= 5; j++){
                appendEmptySlotToBuffer(buffer);
            }
            printBuffer(buffer);
        }
        for(int j = previousTime + 1; j <= 8; j++){
            printEmptyRow();
        }
        printRowBreak();
    } // end of display timetable

    private void printRowBreak(){
        for(int i = 1; i <= (WIDTH + 1) * 6; i++){
            IO.print("-");
        }
        IO.println("-");
    }

    private void printEmptyRow(){
        printRowBreak();
        for(int i = 1; i <= (WIDTH + 1) * 6; i++){
            if(i % (WIDTH + 1) == 1){
                IO.print("|");
            }
            else{
                IO.print(" ");
            }
        }
        IO.println("|");
    }

    private void printBuffer(String[] buffer){
        for(int i = 0; i < buffer.length; i++){
            buffer[i] += "|";
            IO.println(buffer[i]);
            buffer[i] = "";
        }
    }

    private void appendEmptySlotToBuffer(String[] buffer){
        for(int i = 0; i < buffer.length; i++){
            for(int j = 1; j <= (WIDTH + 1); j++){
                if(j % (WIDTH + 1) == 1){
                    buffer[i] += "|";
                }
                else{
                    buffer[i] += " ";
                }
            }
        }
    }

    void appendSlotToBuffer(String[] buffer, TimeSlot timeSlot){
        String startEnd = (timeSlot.getStart() < 10) ? " " + timeSlot.getStart() + "-" + timeSlot.getEnd() :
            timeSlot.getStart() + "-" + timeSlot.getEnd();
        buffer[0] += insertString(startEnd);
        buffer[1] += insertString(timeSlot.getModuleName() + "-" + timeSlot.getClassType().name());
        buffer[2] += insertString(timeSlot.getLecturer());
        buffer[3] += insertString(timeSlot.getRoom());
        buffer[4] += insertString("Wks:" + timeSlot.getModuleDates());
    }

    private String insertString(String inserted){
        StringBuilder constructedString = new StringBuilder("|");
        for(int i = 0; i < (WIDTH - inserted.length()) / 2; i++){
            constructedString.append(" ");
        }
        constructedString.append(inserted);
        for(int i = 0; i < (WIDTH - inserted.length()) / 2; i++){
            constructedString.append(" ");
        }
        if((WIDTH - inserted.length()) % 2 == 1){
            constructedString.append(" ");
        }
        return constructedString.toString();
    }

    @Override
    public int displayInterface(UserType userType) {
        switch (userType) {
            case STUDENT:
            System.out.println("1. Display Module Timetable, 2. Display Course Timetable, 3. Display Student Timetable, 4. Display Room Timetable, 0. Exit");
            // For Student
                break;
            case LECTURER:
            System.out.println("1. Display Module Timetable, 2. Display Course Timetable, 3. Display Lecturer Timetable, 4. Display Room Timetable, 0. Exit");
            // For Lecturer
                break;
            case ADMIN:
            System.out.println("1. Edit Module Timetable, 2. Edit Course Timetable, 3. Edit Student Timetable, 4. Edit Room Timetable, 0. Exit");
            // For Admin
                break;
            default:
                System.out.println("Invalid input");
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    @Override
    public String[] editModuleTimetableLine() {
        String[] output = new String[8];

        IO.println("Enter module code or type '0' to quit.");
        output[0] = scanner.nextLine();
        if (Objects.equals(output[0], "0")) {
            return output;
        }

        IO.println("Enter weeks (Start-End).");
        output[1] = scanner.nextLine();

        IO.println("Enter day (Monday-Sunday).");
        String day = scanner.nextLine().toLowerCase();
        switch (day) {
            case "monday" -> output[2] = "1";
            case "tuesday" -> output[2] = "2";
            case "wednesday" -> output[2] = "3";
            case "thursday" -> output[2] = "4";
            case "friday" -> output[2] = "5";
            case "saturday" -> output[2] = "6";
            case "sunday" -> output[2] = "7";
        }

        IO.println("Enter start time.");
        output[3] = scanner.nextLine();

        IO.println("Enter end time.");
        output[4] = scanner.nextLine();

        IO.println("Enter room code.");
        output[5] = scanner.nextLine();

        IO.println("Enter class type (LEC, LAB, TUT)");
        String type = scanner.nextLine().toLowerCase();
        switch (type) {
            case "lec" -> output[6] = "0";
            case "lab" -> output[6] = "1";
            case "tut" -> output[6] = "2";
        }

        IO.println("Enter lecturer name.");
        output[7] = scanner.nextLine();

        return output;
    }

    @Override
    public String[] editCourseTimetableLine() {
        ArrayList<String> output = new ArrayList<>();

        IO.println("Enter course code or type '0' to quit.");
        output.add(scanner.nextLine());
        if (Objects.equals(output.getFirst(), "0")) {
            String[] outputArray = new String[output.size()];
            outputArray = output.toArray(outputArray);
            return outputArray;
        }

        while (true) {
            IO.println("Enter module code or type '0' to quit.");
            String module = scanner.nextLine();
            if (module.equals("0")) {
                break;
            }

            output.add(module);
        }

        String[] outputArray = new String[output.size()];
        outputArray = output.toArray(outputArray);
        return outputArray;
    }

    @Override
    public String[] editRoomTimetableLine() {
        String[] output = new String[3];

        IO.println("Enter room code or type '0' to quit.");
        output[0] = scanner.nextLine();
        if (output[0].equals("0")) {
            return output;
        }

        IO.println("Enter room type (LEC, LAB)");
        String type = scanner.nextLine().toLowerCase();
        switch (type) {
            case "lec" -> output[1] = "0";
            case "lab" -> output[1] = "1";
        }

        IO.println("Enter room capacity.");
        output[2] = scanner.nextLine();

        return output;
    }

    @Override
    public String[] displayLogin() {
        String[] loginDetails = new String[2];

        System.out.print("Enter username: ");
        loginDetails[0] = scanner.nextLine();
        System.out.print("Enter password: ");
        loginDetails[1] = scanner.nextLine();

        return loginDetails;
    }

    @Override
    public void exit() {
        scanner.close();
    }
}
