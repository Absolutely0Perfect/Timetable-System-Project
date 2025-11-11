import java.util.LinkedList;
import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;

class Data {
    private LinkedList<User> users;
    
    private File userData;
    private File moulesData;

    void initialise(){
        users = new LinkedList();
        userData = new File("../Data/users.csv");
    }

    public void readUserData(){
        try (Scanner scanner = new Scanner(userData)){
            Pattern p = Pattern.compile("\\w+|$");

            String username;
            String password;
            int type;

            while(scanner.hasNext()){
                //username = scanner.next(p);
                //IO.println(scanner.next(p));
                //password = scanner.next(p);
                //IO.println(scanner.next(p));
                //type = scanner.nextInt();
                //IO.println(scanner.nextInt());

                //users.add(new User(username, password, type));
            }

            //remove after testing
            /*for(int i = 0; i < users.size(); i++){
                users.get(i).printInfo();
            }*/
        }
        catch(FileNotFoundException e){
            IO.println("Reading failed");
            e.printStackTrace();
        }
    }
}