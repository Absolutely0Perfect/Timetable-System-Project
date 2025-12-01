import java.util.Objects;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class CLIRead extends ViewRead{
    private final Scanner scanner;

    public CLIRead(){
        scanner = new Scanner(System.in);
    }
    /**
     * <p>@Override method displays statement to propmpt user to selct a module <p>
     */
    @Override
    public String selection(List<String[]> names){
        IO.println("Select a Module");

        for(int i = 0; i < names.size(); i++){
            IO.println(i + ":" + names.get(i)[0] + "-" + names.get(i)[1]);
        }
        int userChoice = scanner.nextInt();

        return names.get(userChoice)[0];
    }
    /**
     * <p>@Overide method that displays a diffrent Type timetable based on User input <p>
     */
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
    /**
     * <p>This method prints a statement that shows a statement that waits for user input <p>
     */
    @Override
    public int editModuleTimetables(){
        IO.println("1. Edit Existing TimeSlots 2. Add New Timeslot. 3. Change Module Leader 0. Back");
        return scanner.nextInt();
    }
    /**
     * <p>This method walkes the user through how to edit a Module timetable  <p>
     */
    @Override
    public TimeSlotDTO[] editModuleTimeSlot(ViewRender viewRender, ModuleTimetable timetable, DataParser dataParser){
        viewRender.displayTimetable(timetable);

        IO.println("Enter starting Time of the TimeSlot you want to edit");
        int userInput;
        TimeSlot ramTimeSlot = null;
        TimeSlot editedTimeSlot = null;
        while(ramTimeSlot == null){
            userInput = scanner.nextInt();
            for(TimeSlot t : timetable.getTimeSlots()){
                if(t.getStart() == userInput){
                    editedTimeSlot = t;
                    try{
                        ramTimeSlot = (TimeSlot) t.clone();
                    } catch (CloneNotSupportedException e){
                        IO.println("Cloning failed");
                    }
                }
            }
            if(ramTimeSlot == null){
                IO.println("Invalid starting Time");
            }
        }

        IO.println("What do you want to edit?");
        IO.println("1. Weeks 2. Day 3. Time 4. Room 5. Class Type");
        userInput = scanner.nextInt();

        switch(userInput){
        case 1:
            IO.println("Enter new Dates");
            String newDates = scanner.nextLine();
            ramTimeSlot.setModuleDates(newDates);
            break;
        case 2:
            IO.println("Enter new Day");
            IO.println("Enter day (Monday-Saturday).");

            String day = scanner.nextLine().toLowerCase();
            Day newDay = null;
            switch (day) {
            case "monday" -> newDay = Day.MONDAY;
            case "tuesday" -> newDay = Day.TUESDAY;
            case "wednesday" -> newDay = Day.WEDNESDAY;
            case "thursday" -> newDay = Day.THURSDAY;
            case "friday" -> newDay = Day.FRIDAY;
            case "saturday" -> newDay = Day.SATURDAY;
            }

            ramTimeSlot.setDay(newDay);
            if(!dataParser.getModule(ramTimeSlot.getModuleName()).isSlotFree(ramTimeSlot)){
                IO.println("Conflict within Module");
                return null;
            }
            else if(!dataParser.getRoom(ramTimeSlot.getRoom()).isSlotFree(ramTimeSlot)){
                IO.println("Conflict within Room");
                return null;
            }
            break;
        case 3:
            IO.println("Enter new starting Time");
            int newStart = scanner.nextInt();
            IO.println("Enter new end Time");
            int newEnd = scanner.nextInt();

            ramTimeSlot.setStart(newStart);
            ramTimeSlot.setEnd(newEnd);
            if(!dataParser.getModule(ramTimeSlot.getModuleName()).isSlotFree(ramTimeSlot)){
                IO.println("Conflict within Module");
                return null;
            }
            else if(!dataParser.getRoom(ramTimeSlot.getRoom()).isSlotFree(ramTimeSlot)){
                IO.println("Conflict within Room");
                return null;
            }
            break;
        case 4:
            IO.println("Enter new Room");
            String newRoom = scanner.nextLine();
            if(dataParser.getRoom(newRoom) == null){
                IO.println("Unknown Room");
                return null;
            }

            ramTimeSlot.setRoom(newRoom);
            if(!dataParser.getRoom(ramTimeSlot.getRoom()).isSlotFree(ramTimeSlot)){
                IO.println("Conflict within Room");
                return null;
            }
            break;
        case 5:
            IO.println("Enter new type 1. Lecture 2. Lab 3. Tutorial");
            ClassType newClassType = ClassType.toClassType(scanner.nextInt() - 1);

            RoomTimetable currentRoom = (RoomTimetable) dataParser.getRoom(ramTimeSlot.getRoom());
            if(newClassType == ClassType.LAB && currentRoom.getRoomType() == RoomType.LEC){
                IO.println("Cant have labs in Lecture Halls");
            }
            break;
        }

        IO.println("Do you want to write change to the file?");
        IO.println("1. Yes 2. No");
        userInput = scanner.nextInt();
        if(userInput == 2){
            return null;
        }
        else{
            TimeSlotDTO[] output = new TimeSlotDTO[2];
            output[0] = editedTimeSlot.toDTO();
            output[1] = ramTimeSlot.toDTO();

            return output;
        }
    }

    public String[] editModuleLeader(ModuleTimetable timetable, DataParser dataParser){
        IO.println("Write new Module Leader, 0 for exit");
        String newLecturer = scanner.nextLine();

        if(!dataParser.isLecturerPresent(newLecturer)){
            IO.println("Unknown lecturer");
            return null;
        }

        String[] output = new String[3];
        output[0] = timetable.getName();
        output[1] = timetable.getTimeSlots().get(0).getLecturer();
        output[2] = newLecturer;

        return output;
    }
        String[] output = new String[3];
        output[0] = timetable.getName();
        output[1] = timetable.getTimeSlots().get(0).getLecturer();
        output[2] = newLecturer;

        return output;
    }

    /**
     * <p> This method walks the user through the process of add a module to a timeslot <p>
     */
    @Override
    public String[] addModuleTimeSlot() {
        String[] output = new String[8];

        IO.println("Enter module code or type '0' to quit.");
        output[0] = scanner.nextLine();
        if (Objects.equals(output[0], "0")) {
            return output;
        }

        IO.println("Enter weeks (Start-End).");
        output[1] = scanner.nextLine();

        IO.println("Enter day (Monday-Saturday).");
        String day = scanner.nextLine().toLowerCase();
        switch (day) {
            case "monday" -> output[2] = "1";
            case "tuesday" -> output[2] = "2";
            case "wednesday" -> output[2] = "3";
            case "thursday" -> output[2] = "4";
            case "friday" -> output[2] = "5";
            case "saturday" -> output[2] = "6";
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
    public int editCourseTimetables(){
        return 0;
    }

    @Override
    public String[] editCourseModules(){
        String[] output = null;
        return output;
    }
    /**
     * <p>This is a method that shows the user how to add course <p>
     */
    @Override
    public String[] addCourse() {
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
    public int editRooms(){
        return 0;
    }
    
    @Override
    public String[] editRoom(){
        String[] output = null;
        return output;
    }

    @Override
    public String[] addRoom() {
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
    /**
     * <p>This method walks the user through to Dispaly log in <p>
     */
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