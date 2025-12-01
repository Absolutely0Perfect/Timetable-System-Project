import java.util.Arrays;
/**
 * <p> This class is to manages the flow of information form the other classes
 * It also controls the execution of the programme</p>
 */
class Control {
    private boolean running = false;
    private boolean userLogged = false; //?
    private DataParser dataParser;
    private DataWriter dataWriter;
    private ViewRead viewRead;
    private ViewRender viewRender;
    private User currentUser = null;

    public boolean isRunning(){
        return running;
    }
    /**
     * <p>This inherites the data class and reads the data from files <p>
     */
    public Control() {
        dataParser = new DataParser();
        dataWriter = new DataWriter();
        viewRead = new CLIRead();
        viewRender = new CLIRender();
        running = true;
    }
    /**
     * <p>method with enumerator for each edit and display type <p>
     */
    public void update(){
        if(!userLogged){
            login();
        }
        int userInput;
        userInput = viewRead.displayInterface(currentUser.getUserType());
        if (userInput == 0) {
            exit();
            return;
        }

        if(currentUser.getUserType() == UserType.ADMIN){
            switch(userInput){
            case 1 -> editModuleTimetable();
            case 2 -> editCourseTimetable();
            case 3 -> editStudentTimetable();
            case 4 -> editRoomTimetable();
            }
            dataParser.reload();
        }
        else {switch (userInput) {
            case 1 -> displayModuleTimetable();
            case 2 -> displayCourseTimetable();
            case 3 -> displayPersonalTimetable();
            case 4 -> displayRoomTimetable();
            }
        }
    }
    /**
     * <p>checks to see if log in is succesful  <p>
     */
    private void login() {
        while (true) {
            String[] loginDetails = viewRead.displayLogin();
            IO.println(Arrays.toString(loginDetails));
            currentUser = dataParser.findUser(loginDetails[0], loginDetails[1]);
            if(currentUser == null){
                IO.println("Invalid username or password. \nTry again");
            }
            else{
                IO.println("Welcome " + currentUser.getUsername() + "!");
                userLogged = true;
                break;
            }
        }
    }
    /**
     * <p>Method displays module <p>
     */
    public void displayModuleTimetable() {
        viewRender.displayTimetable(
            dataParser.getModule(
                viewRead.selection(
                    dataParser.getAllModuleNames())));
    }
    /**
     * <p>method to display course <p>
     */
    public void displayCourseTimetable() {
        viewRender.displayTimetable(
            dataParser.getCourse(
                viewRead.selection(
                    dataParser.getAllCourseNames())));
    }
    /**
     * <p>method to display personal timetable <p>
     */
    public void displayPersonalTimetable() {
        Student castedUser = (Student) currentUser;
        viewRender.displayTimetable(
            castedUser.getPersonalTimetable());
    }
    /**
     * <p>method to display room timetable <p>
     */
    public void displayRoomTimetable() {
        viewRender.displayTimetable(
            dataParser.getRoom(
                viewRead.selection(
                    dataParser.getAllRoomNames())));
    }
    /**
     * <p>method to edit module timetable <p>
     */
    public void editModuleTimetable() {
        ModuleTimetable timetable = dataParser.getModule(viewRead.selection(dataParser.getAllModuleNames()));
        int userInput = viewRead.editModuleTimetables();

        switch(userInput){
        case 1:
            TimeSlotDTO[] timeSlotDTO = viewRead.editModuleTimeSlot(viewRender, timetable, dataParser);
            if(timeSlotDTO == null){
                return;
            }
            dataWriter.editTimeSlot(timeSlotDTO);
            break;
        case 2:
            
            break;
        case 3:
            dataWriter.addModuleTimeSlot(viewRead.addModuleTimeSlot());
            break;
        }
    }
    /**
     * <p>method to edit course timetable <p>
     */
    public void editCourseTimetable() {
        //under construction
    }
    /**
     * <p>method to display student timetable <p>
     */
    public void editStudentTimetable() {
        //under construction
    }
    /**
     * <p>method to display room timetable <p>
     */
    public void editRoomTimetable() {
        //under construction
    }
    /**
     * <p>this is the method to exit the interface <p>
     */
    void exit() {
        viewRead.exit();
        running = false;
    }
}