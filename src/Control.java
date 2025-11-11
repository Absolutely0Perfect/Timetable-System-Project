import java.util.Scanner;

class Control {
    private boolean running = false;
    private View view;

    public boolean isRunning(){
        return running;
    }

    public void initialise() {
        //to be implemented
        view = new CommandLineInterface(); // should be a drop in replacement for gui class if we need to make one
        displayInterface();
    }

    public void displayInterface() {
        // quoter for user what user wants to do
        while (true) {
            String[] loginDetails = view.displayLogin();
            if (loginDetails != null) { // implement checking user and password
                break;
            }
        }

        view.displayInterface();
    }

    public void displayTimetable() { //subject to change
        // add implementation
        view.displayTimetable();
    }

    void exit() {
        view.exit();
        running = false;
    }
}