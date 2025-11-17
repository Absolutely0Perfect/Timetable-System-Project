/**
 * <p>Class to control the running of the project </p>
 */
public class Main{
    public static void main(String[] args){
        Control control = new Control();

        while(control.isRunning()){
            control.update();
        }
    }
}