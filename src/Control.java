import java.util.Scanner;

class Control{
    public static Scanner scanner;
    
    private boolean running = false;

    public boolean isRunning(){
        return running;
    }

    public void initialise(){
        scanner = new Scanner(System.in);
        if (User.login() == 1){
            running = true;
        }
        else{
            scanner.close();
        }
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