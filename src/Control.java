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
        //to be implemented
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

        switch (currentUser.getUserType()) {
            case ADMIN: switch (userInput) {
                case 1 -> editModuleTimetable();
                case 2 -> editCourseTimetable();
                case 3 -> editStudentTimetable();
                case 4 -> editRoomTimetable();
            }
            case STUDENT: switch (userInput) {
                case 1 -> displayTimetable();
            }
            //implement the other user type inputs
        }
    }

    private void login() {
        // quoter for user what user wants to do
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

    public void displayTimetable() { //subject to change
        view.displayTimetable(
            dataReader.getModule(
                view.moduleSelection(
                    dataReader.getAllModuleNames())));
    }

    public void editModuleTimetable() {
        String[] output;
        int i = 1;

        try (FileWriter modules = new FileWriter("../DataReader/modules.csv")) {
            while (true) {
                output = view.editModuleTimetableLine();
                if (Objects.equals(output[0], "0")) {
                    break;
                }

                StringBuilder line = new StringBuilder(output[0]);
                for (int j=1;j< output.length;j++) {
                    line.append(",").append(output[j]);
                }
                line.append("\n");
                modules.append(line);
                i++;
            }
        } catch (IOException e) {
            IO.println("An error occurred.");
        }
    }

    public void editCourseTimetable() {
        String[] output;
        int i = 1;

        try (FileWriter courses = new FileWriter("../DataReader/courses.csv")) {
            while (true) {
                output = view.editCourseTimetableLine();
                if (Objects.equals(output[0], "0")) {
                    break;
                }

                StringBuilder line = new StringBuilder(output[0]);
                for (int j=1;j< output.length;j++) {
                    line.append(",").append(output[j]);
                }
                line.append("\n");
                courses.append(line);
                i++;
            }
        } catch (IOException e) {
            IO.println("An error occurred.");
        }
    }

    public void editStudentTimetable() {
        //to be implemented
    }

    public void editRoomTimetable() {
        String[] output;
        int i = 1;

        try (FileWriter rooms = new FileWriter("../DataReader/rooms.csv")) {
            while (true) {
                output = view.editRoomTimetableLine();
                if (Objects.equals(output[0], "0")) {
                    break;
                }

                StringBuilder line = new StringBuilder(output[0]);
                for (int j = 1; j < output.length; j++) {
                    line.append(",").append(output[j]);
                }

                line.append("\n");
                rooms.append(line);
                i++;
            }
        } catch (IOException e) {
            IO.println("An error occurred.");
        }
    }

    void exit() {
        view.exit();
        running = false;
    }
}