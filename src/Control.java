import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
/**
 * <p> This class is to manages the flow of information form the other classes
 * It also controls the execution of the programme</p>
 */
class Control {
    private boolean running = false;
    private boolean userLogged = false; //?
    private DataParser dataParser;
    private ViewRead viewRead;
    private ViewRender viewRender;
    private User currentUser = null;

    public boolean isRunning(){
        return running;
    }

    public Control() {
        dataParser = new DataParser();
        viewRead = new CLIRead();
        viewRender = new CLIRender();
        running = true;
    }

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

    public void displayModuleTimetable() {
        viewRender.displayTimetable(
            dataParser.getModule(
                viewRead.selection(
                    dataParser.getAllModuleNames())));
    }

    public void displayCourseTimetable() {
        viewRender.displayTimetable(
            dataParser.getCourse(
                viewRead.selection(
                    dataParser.getAllCourseNames())));
    }

    public void displayPersonalTimetable() {
        Student castedUser = (Student) currentUser;
        viewRender.displayTimetable(
            castedUser.getPersonalTimetable());
    }

    public void displayRoomTimetable() {
        viewRender.displayTimetable(
            dataParser.getRoom(
                viewRead.selection(
                    dataParser.getAllRoomNames())));
    }

    public void editModuleTimetable() {
        //under construction
    }

    public void editCourseTimetable() {
        //under construction
    }

    public void editStudentTimetable() {
        //under construction
    }

    public void editRoomTimetable() {
        //under construction
    }

    void exit() {
        viewRead.exit();
        running = false;
    }
}