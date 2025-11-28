import java.util.Scanner;
import java.util.ArrayList;
/**
*  <p> This class is the CLI Used to Display any Inputs the user needs to input
 * Referenece from the View Class </p>
*/
public class CommandLineInterface extends View {
    private Scanner scanner;

    CommandLineInterface() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void displayTimetable(ModuleTimetable module) {
        ArrayList<TimeSlot> slots = module.getModuleTimes();

        String[] buffer = {"", "", "", "", ""};

        int currentDay = -1;
        boolean theRowPrinted = false;
        int previousTime = 0;
        int previousDay = 5;
        int time;
        int day;

        IO.println("-------------------------------------------------------------------------------------------------");
        IO.println("|               |               |               |               |               |               |");

        for(int i = 0; i < slots.size(); i++){
            time  = slots.get(i).getStart() - 9; // offset so that 0 equals 9 am
            day  = slots.get(i).getDay().toInt() - 1;

            for(int j = previousDay + 1; j <= 5 && (j < day || previousTime < time); j++){
                for(int k = 0; k < 5; k++){
                    buffer[k] += "|               ";
                }
    
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
                IO.println("-------------------------------------------------------------------------------------------------");
                IO.println("|               |               |               |               |               |               |");
            }

            if(!theRowPrinted){
                IO.println("-------------------------------------------------------------------------------------------------");
                theRowPrinted = true;
            }

            for(int j = Math.max(0, currentDay); j < day; j++){
                for(int k = 0; k < 5; k++){
                    buffer[k] += "|               ";
                }
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
                for(int k = 0; k < 5; k++){
                    buffer[k] += "|               ";
                }
            }
            printBuffer(buffer);
        }
        for(int j = previousTime + 1; j <= 8; j++){
            IO.println("-------------------------------------------------------------------------------------------------");
            IO.println("|               |               |               |               |               |               |");
        }
        IO.println("-------------------------------------------------------------------------------------------------");
    }

    private void printBuffer(String[] buffer){
        for(int i = 0; i < buffer.length; i++){
            buffer[i] += "|";
            IO.println(buffer[i]);
            buffer[i] = "";
        }
    }

    void appendSlotToBuffer(String[] buffer, TimeSlot timeSlot){
        if(timeSlot.getStart() < 10){
            buffer[0] += "|     0" + timeSlot.getStart() + "-" + timeSlot.getEnd() + "     ";
        }
        else{
            buffer[0] += "|     " + timeSlot.getStart() + "-" + timeSlot.getEnd() + "     ";
        }
        buffer[1] += "|  " + timeSlot.getModuleName() + "-" + timeSlot.getClassType().name() + "   ";
        buffer[2] += "|";
        for(int i = 0; i < (15 - timeSlot.getLecturer().length()) / 2; i++){
            buffer[2] += " ";
        }
        buffer[2] += timeSlot.getLecturer();
        for(int i = 0; i < (15 - timeSlot.getLecturer().length()) / 2; i++){
            buffer[2] += " ";
        }
        if(timeSlot.getLecturer().length() % 2 == 0){
            buffer[2] += " ";
        }
        buffer[3] += "|     " + timeSlot.getRoom() + "     ";
        buffer[4] += "|   Wks:" + timeSlot.getModuleDates() + "    ";
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
