import java.util.Scanner;

<<<<<<< Updated upstream
class Control{
    boolean running = false;
    private Scanner scanner;

    Control(){
        this.scanner = new Scanner(System.in);
    }
=======
class Control {
    private boolean running = false;
    private View view;
>>>>>>> Stashed changes

    public boolean isRunning(){
        return running;
    }

    public void initialise() {
        //to be implemented
        view = new CommandLineInterface(); // should be a drop in replacement for gui class if we need to make one
        displayInterface();
    }
<<<<<<< Updated upstream
    
    void exit(){
        scanner.close();
=======

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
>>>>>>> Stashed changes
        running = false;
    }
}