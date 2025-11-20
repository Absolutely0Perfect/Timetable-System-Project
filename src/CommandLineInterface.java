import java.util.Scanner;
import java.util.LinkedList;
/**
*  <p> This class is the CLI Used to Display any Inputs the user needs to input
 * Referenece from the View Class </p>
*/
public class CommandLineInterface extends View {
    private Scanner scanner;

    CommandLineInterface() {
        scanner = new Scanner(System.in);
    }

    @Overide
    public void displayTimetable(ModuleTimetable module) {
        LinkedList<TimeSlot> slots = module.getModuleTimes();

        int previousTime = 0;
        int previousDay = 0;
        int time;
        int day;
        for(int i = 0; i < slots.size(); i++){
            time  = slots.get(i).getStart();
            day  = slots.get(i).getDay().toInt();

            for(int j = previous; j <= stop - 10; j++){
                IO.println("-------------------------------------------------------------------------------------------------");
                IO.println("|               |               |               |               |               |               |");
            }


            previousTime = time;
            previousDay = day;
        }
        System.out.println();
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
