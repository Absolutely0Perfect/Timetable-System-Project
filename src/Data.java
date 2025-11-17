import java.util.LinkedList;
import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.FileNotFoundException;

class Data {
    private LinkedList<User> users;
    private File userData;
    private File moulesData;

    public Data(){
        users = new LinkedList<>();
        userData = new File("../Data/users.csv");

        readUserData();
    }

    /**
     * <p> This class reads and stores data from other classes
     * takes the information and gives it to other classes
     * it also takes the information and creates new informaiton with it </p>
     */

    private void readUserData(){
        try (Scanner scanner = new Scanner(userData)){
            Pattern p = Pattern.compile("\\w+|$");
            Matcher match;

            String curentLine;
            String username;
            String password;
            int userType;

            while(scanner.hasNext()){
                curentLine = scanner.next();
                match = p.matcher(curentLine);

                match.find();
                username = curentLine.substring(match.start(), match.end());
                match.find();
                password = curentLine.substring(match.start(), match.end());
                match.find();
                userType = Integer.parseInt(curentLine.substring(match.start(), match.end()));

                users.add(new User(username, password, UserType.toUserType(userType)));
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public User findUser(String username, String password){
        for(int i = 0; i < users.size(); i++){
            if (users.get(i).compare(username, password)){
                return users.get(i);
            }
        }
        return null;
    }
}