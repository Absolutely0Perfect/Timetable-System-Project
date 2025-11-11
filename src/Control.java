import java.util.Arrays;

class Control {
    private boolean running = false;
    private View view;

    public boolean isRunning(){
        return running;
    }

    public Control() {
        //to be implemented
        view = new CommandLineInterface(); // should be a drop in replacement for gui class if we need to make one
        displayInterface();
    }

    public void displayInterface() {
        // quoter for user what user wants to do
        while (true) {
            String[] loginDetails = view.displayLogin();
            System.out.println(Arrays.toString(loginDetails));
            if (loginDetails != null) { // implement checking login details
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