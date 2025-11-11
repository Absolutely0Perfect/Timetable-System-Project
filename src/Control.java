import java.util.Scanner;

class Control{
    boolean running = false;
    private Scanner scanner;

    Control(){
        this.scanner = new Scanner(System.in);
    }

    public boolean isRunning(){
        return running;
    }

    public void initialise(){
        //to be implemented
    }
    
    void exit(){
        scanner.close();
        running = false;
    }
}