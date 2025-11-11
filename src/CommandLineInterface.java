import java.util.Scanner;

public class CommandLineInterface extends View {
    private static Scanner scanner;

    CommandLineInterface() {
        scanner = new Scanner(System.in);
    }

    public void displayTimetable() {

    }

    @Override
    public void displayInterface() {
        System.out.println("hello");
    }

    @Override
    public String[] displayLogin() {
        String[] loginDetails = new String[2];

        System.out.print("Enter username: ");
        loginDetails[0] = scanner.nextLine();
        System.out.print("Enter password: ");
        loginDetails[1] = scanner.nextLine();

        return loginDetails;
    }

    @Override
    public void exit() {
        scanner.close();
    }
}
