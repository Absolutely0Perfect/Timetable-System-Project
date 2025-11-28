import java.util.Scanner;
import java.util.ArrayList;
/**
*  <p> This class is the CLI Used to Display any Inputs the user needs to input
 * Referenece from the View Class </p>
*/
public class CommandLineInterface extends View {
    private Scanner scanner;
    public final int width = 20;

    CommandLineInterface() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void displayTimetable(ModuleTimetable module) {
        ArrayList<TimeSlot> slots = module.times;

        String[] buffer = {"", "", "", "", ""};

        int currentDay = -1;
        boolean theRowPrinted = false;
        int previousTime = 0;
        int previousDay = 5;
        int time;
        int day;

        printEmptyRow();

        for(int i = 0; i < slots.size(); i++){
            time  = slots.get(i).getStart() - 9; // offset so that 0 equals 9 am
            day  = slots.get(i).getDay().toInt() - 1;

            for(int j = previousDay + 1; j <= 5 && (j < day || previousTime < time); j++){
                appendEmptySlotToBuffer(buffer);
    
                if(j == 5){
                    printBuffer(buffer);
                    theRowPrinted = false;
                    currentDay = -1;
                }
                else{
                    currentDay = j + 1;
                }
            }
            
            for(int j = previousTime + 1; j <= time - 1; j++){
                printEmptyRow();
            }

            if(!theRowPrinted){
                printRowBreak();
                theRowPrinted = true;
            }

            for(int j = Math.max(0, currentDay); j < day; j++){
                appendEmptySlotToBuffer(buffer);
            }

            appendSlotToBuffer(buffer, slots.get(i));
            currentDay = day + 1;
            if(day == 5){
                printBuffer(buffer);
                theRowPrinted = false;
                currentDay = -1;
            }

            previousTime = time;
            previousDay = day;
        }
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
        for(int i = 1; i <= (width + 1) * 6; i++){
            IO.print("-");
        }
        IO.println("-");
    }

    private void printEmptyRow(){
        printRowBreak();
        for(int i = 1; i <= (width + 1) * 6; i++){
            if(i % (width + 1) == 1){
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
            for(int j = 1; j <= (width + 1); j++){
                if(j % (width + 1) == 1){
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
        String constructedString = "|";
        for(int i = 0; i < (width - inserted.length()) / 2; i++){
            constructedString += " ";
        }
        constructedString += inserted;
        for(int i = 0; i < (width - inserted.length()) / 2; i++){
            constructedString += " ";
        }
        if((width - inserted.length()) % 2 == 1){
            constructedString += " ";
        }
        return constructedString;
    }

    @Override
    public int displayInterface(UserType userType) {

        System.out.println("1. Display Module Timetable, 0. Exit");
        return scanner.nextInt();
        /*switch (userType) {
            case STUDENT:
            System.out.println("1. Display Module Timetable, 2. Display Course Timetable, 3. Display Student Timetable, 4. Display Room Timetable, 0. Exit");
            // For Studnet
                break;
            case LECTURER:
            System.out.println("1. Display Module Timetable, 2. Display Course Timetable, 3. Display Lecturer Timetable, 4. Display Room Timetable, 0. Exit");
            // For Lectuerer
                break;
            case STAFF:
            System.out.println("1. Display Module Timetable, 2. Display Course Timetable, 3. Display Room Timetable, 0. Exit");
            // For Staff
                break;
            case ADMIN:
            System.out.println("1. Edit Module Timetable, 2. Edit Course Timetable, 3. Edit Student Timetable, 4. Edit Room Timetable, 0. Exit");
            // For Admin
                break;
            default:
                System.out.println("Invalid input"); */
        }//to be implemnted later

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
