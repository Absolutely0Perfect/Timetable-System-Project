import java.util.Arrays;

/**
 * This class is to manages the flow of information form the other classes
 * It also controls the execution of the programme
 */
class Control {
    private boolean running = false;
    private boolean userLogged = false;
    private Data data;
    private View view;
    private User currentUser = null;

    public boolean isRunning(){
        return running;
    }

    public Control() {
        //to be implemented
        data = new Data();
        view = new CommandLineInterface(); // should be a drop in replacement for gui class if we need to make one
        running = true;
    }

    public void update(){
        if(!userLogged){
            login();
        }

        int userInput = -1;
        userInput = view.displayInterface(currentUser.getUserType());
    }

    private void login() {
        // quoter for user what user wants to do
        while (true) {
            String[] loginDetails = view.displayLogin();
            System.out.println(Arrays.toString(loginDetails));
            currentUser = data.findUser(loginDetails[0], loginDetails[1]);
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
        // add implementation
        view.displayTimetable();
    }

    void exit() {
        view.exit();
        running = false;
    }
}