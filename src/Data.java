import java.util.LinkedList;
import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.FileNotFoundException;
/**
 * <p> This class reads and stores data from other classes
 * takes the information and gives it to other classes
 * it also takes the information and creates new informaiton with it </p>
 */
class Data {
    private LinkedList<User> users;
    private LinkedList<ModuleTimetable> modules;
    private File userData;
    private File modulesData;

    public Data(){
        users = new LinkedList<>();
        userData = new File("../Data/users.csv");
        modulesData = new File("../Data/modules.csv");

        readUserData();
    }

    private void readUserData(){
        try (Scanner scanner = new Scanner(userData)){
            Pattern p = Pattern.compile("[^\\,]+");
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

    private void readModuleData(){
        try (Scanner scanner = new Scanner(modulesData)){
            Pattern p = Pattern.compile("[^\\,]+");
            Matcher match;

            String curentLine;
            String moduleName;
            String moduleDates;
            int day;
            int start;
            int end;
            String room;
            int classType;
            String lecturer;

            while(scanner.hasNext()){
                curentLine = scanner.next();
                match = p.matcher(curentLine);

                match.find();
                moduleName = curentLine.substring(match.start(), match.end());
                match.find();
                moduleDates = curentLine.substring(match.start(), match.end());
                match.find();
                day = Integer.parseInt(curentLine.substring(match.start(), match.end()));
                match.find();
                start = Integer.parseInt(curentLine.substring(match.start(), match.end()));
                match.find();
                end = Integer.parseInt(curentLine.substring(match.start(), match.end()));
                match.find();
                room = curentLine.substring(match.start(), match.end());
                match.find();
                classType = Integer.parseInt(curentLine.substring(match.start(), match.end()));
                match.find();
                lecturer = curentLine.substring(match.start(), match.end());
                
                if(!findModule(moduleName)){
                    modules.add(new ModuleTimetable(moduleName));
                }

                addTimeSlot(new TimeSlot(moduleName, moduleDates, Day.toDay(day), start, end, room, ClassType.toClassType(classType), lecturer));
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

    public boolean findModule(String name){
        for(ModuleTimetable m : modules){
            if(m.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public void addTimeSlot(TimeSlot timeSlot){
        for(int i = 0; i < modules.size(); i++){
            if(modules.get(i).getName().equals(timeSlot.getModuleName())){
                modules.get(i).add(timeSlot);
            }
        }
    }
    public ModuleTimetable getModule(String moduleName){
        for(int i = 0; i < modules.size(); i++){
            if(modules.get(i).getName().equals(moduleName)){
                return modules.get(i);
            }
        }
        return null;
    }
}

