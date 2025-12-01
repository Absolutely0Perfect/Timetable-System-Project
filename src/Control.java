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
    private boolean userLogged = false;
    private DataReader dataReader;
    private View view;
    private User currentUser = null;

    public boolean isRunning(){
        return running;
    }

    public Control() {
        dataReader = new DataReader();
        view = new CommandLineInterface(); // should be a drop in replacement for gui class if we need to make one
        running = true;
    }

    public void update(){
        if(!userLogged){
            login();
        }

        int userInput;
        userInput = view.displayInterface(currentUser.getUserType());
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
            dataReader.reload();
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
            String[] loginDetails = view.displayLogin();
            IO.println(Arrays.toString(loginDetails));
            currentUser = dataReader.findUser(loginDetails[0], loginDetails[1]);
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
        view.displayTimetable(
            dataReader.getModule(
                view.selection(
                    dataReader.getAllModuleNames())));
    }

    public void displayCourseTimetable() {
        view.displayTimetable(
            dataReader.getCourse(
                view.selection(
                    dataReader.getAllCourseNames())));
    }

    public void displayPersonalTimetable() {
        Student castedUser = (Student) currentUser;
        view.displayTimetable(
            castedUser.getPersonalTimetable());
    }

    public void displayRoomTimetable() {
        view.displayTimetable(
            dataReader.getRoom(
                view.selection(
                    dataReader.getAllRoomNames())));
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
        view.exit();
        running = false;
    }
}