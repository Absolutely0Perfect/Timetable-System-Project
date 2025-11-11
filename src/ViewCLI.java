import java.util.Scanner;

class ViewCLI{

    public void askForLogin(Scanner scanner, String username, String password){
        IO.println("Hi! Please enter Your login!");
        username = scanner.nextLine();

        IO.println("Please enter Your password!");
        password = scanner.nextLine();
    }
}