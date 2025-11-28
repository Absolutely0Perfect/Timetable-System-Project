import java.util.ArrayList;
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
    private ArrayList<User> users;
    private ArrayList<ModuleTimetable> modules;
    private File userData;
    private File modulesData;

    public Data(){
        this.users = new ArrayList<>();
        this.modules = new ArrayList<>();
        this.userData = new File("../Data/users.csv");
        this.modulesData = new File("../Data/modules.csv");

        readUserData();
        readModuleData();
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

                this.users.add(new User(username, password, UserType.toUserType(userType)));
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    private void readModuleData(){
        try (Scanner scanner = new Scanner(modulesData)){
            IO.println("Found a file!");
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
                    this.modules.add(new ModuleTimetable(moduleName));
                    IO.println("Added module" + moduleName);
                }

                addTimeSlot(new TimeSlot(moduleName, moduleDates, Day.toDay(day), start, end, room, ClassType.toClassType(classType), lecturer));
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public User findUser(String username, String password){
        for(User u : this.users){
            if (u.compare(username, password)){
                return u;
            }
        }
        return null;
    }

    public boolean findModule(String name){
        for(ModuleTimetable m : this.modules){
            if(m.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public void addTimeSlot(TimeSlot timeSlot){
        for(int i = 0; i < this.modules.size(); i++){
            if(this.modules.get(i).getName().equals(timeSlot.getModuleName())){
                this.modules.get(i).add(timeSlot);
            }
        }
    }
    public ModuleTimetable getModule(String moduleName){
        for(ModuleTimetable m : this.modules){
            if(m.getName().equals(moduleName)){
                return m;
            }
        }
        return null;
    }

    public ArrayList<String> getAllModuleNames(){
        ArrayList<String> constructed = new ArrayList<>();
        for(ModuleTimetable m : this.modules){
            constructed.add(m.getName());
        }
        return constructed;
    }
}

