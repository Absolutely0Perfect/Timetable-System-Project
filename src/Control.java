import java.util.Scanner;

class Control{
    boolean running = false;
    public static Scanner scanner;

    public boolean isRunning(){
        return running;
    }

    public void initialise(){
        //to be implemented
    }

    public void displayInterface(){
        // quoter for user what user wants to do
    }

    public void displayTimetable(){ //subject to change
        // add implementation
    }

    void exit(){
        scanner.close();
        running = false;
    }
}