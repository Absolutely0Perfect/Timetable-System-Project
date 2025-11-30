import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * <p> This class reads and stores data from other classes
 * takes the information and gives it to other classes
 * it also takes the information and creates new informaiton with it </p>
 */
class DataReader extends Data{
    private Pattern p;
    private Matcher match;

    private List<User> users;
    private List<ModuleTimetable> rooms;
    private List<ModuleTimetable> modules;
    private List<ModuleTimetable> courses;
    private Map<String, String> names;

    public DataReader(){
        super();

        p = Pattern.compile("[^\\,]+");

        this.users = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.modules = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.names = new HashMap<>();

        readRoomData();
        readModuleData();
        readUserData();
        readCourseData();
        readNamesData();
    }

    public void reload(){
        this.users.clear();
        this.rooms.clear();
        this.modules.clear();
        this.courses.clear();
        this.names.clear();

        readRoomData();
        readModuleData();
        readUserData();
        readCourseData();
        readNamesData();
    }

    private void readUserData(){
        try (Scanner scanner = new Scanner(this.userData)){

            String curentLine;
            String username;
            String password;
            String module;
            String name;
            UserType userType;

            while(scanner.hasNext()){
                curentLine = scanner.next();
                match = p.matcher(curentLine);

                match.find();
                username = curentLine.substring(match.start(), match.end());
                match.find();
                password = curentLine.substring(match.start(), match.end());
                match.find();
                userType = UserType.toUserType(Integer.parseInt(curentLine.substring(match.start(), match.end())));

                switch (userType){
                case STUDENT:
                    this.users.add(new Student(username, password, userType));
                    while(match.find()){
                        module = curentLine.substring(match.start(), match.end());
                        addModuleToPerson(username, module);
                    }
                    break;
                case LECTURER:
                    match.find();
                    name = curentLine.substring(match.start(), match.end());
                    this.users.add(new Lecturer(username, password, userType, name));
                    while(match.find()){
                        module = curentLine.substring(match.start(), match.end());
                        addModuleToPerson(username, module);
                    }
                    break;
                case ADMIN:
                    this.users.add(new Student(username, password, userType));
                    break;
                }
            }
        }
        catch(FileNotFoundException e){
            IO.println("File not found");
        }
    }

    private void readRoomData(){
        try (Scanner scanner = new Scanner(this.roomData)){

            String curentLine;
            String roomName;
            int roomType;
            int capacity;

            while(scanner.hasNext()){
                curentLine = scanner.next();
                match = p.matcher(curentLine);

                match.find();
                roomName = curentLine.substring(match.start(), match.end());
                match.find();
                roomType = Integer.parseInt(curentLine.substring(match.start(), match.end()));
                match.find();
                capacity = Integer.parseInt(curentLine.substring(match.start(), match.end()));

                this.rooms.add(new RoomTimetable(roomName, RoomType.toRoomType(roomType), capacity));
            }
        }
        catch(FileNotFoundException e){
            IO.println("File not found");
        }
    }

    private void readCourseData(){
        try (Scanner scanner = new Scanner(this.coursesData)){

            String curentLine;
            String courseCode;
            String module;

            while(scanner.hasNext()){
                curentLine = scanner.next();
                match = p.matcher(curentLine);

                match.find();
                courseCode = curentLine.substring(match.start(), match.end());

                this.courses.add(new CourseTimetable(courseCode));

                while(match.find()){
                    module = curentLine.substring(match.start(), match.end());
                    addModuleToCourse(courseCode, module);
                }
            }
        }
        catch(FileNotFoundException e){
            IO.println("File not found");
        }
    }

    private void readModuleData(){
        try (Scanner scanner = new Scanner(this.modulesData)){

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
                }
                
                addTimeSlot(new TimeSlot(moduleName, moduleDates, Day.toDay(day), start, end, room, ClassType.toClassType(classType), lecturer), modules, rooms);
            }
        }
        catch(FileNotFoundException e){
            IO.println("File not found");
        }
    }

    private void readNamesData(){
        try (Scanner scanner = new Scanner(this.namesData)){

            String curentLine;
            String code;
            String name;

            while(scanner.hasNext()){
                curentLine = scanner.next();
                match = p.matcher(curentLine);

                match.find();
                code = curentLine.substring(match.start(), match.end());
                match.find();
                name = curentLine.substring(match.start(), match.end());

                this.names.put(code, name);
            }
        }
        catch(FileNotFoundException e){
            IO.println("File not found");
        }
    }

    public User findUser(String username, String password){
        for(User u : this.users){
            if (u.equals(username, password)){
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

    public void addTimeSlot(TimeSlot timeSlot, List<ModuleTimetable>... timetables){
        for (List<ModuleTimetable> timetable : timetables) {
            for (ModuleTimetable moduleTimetable : timetable) {
                if (moduleTimetable instanceof RoomTimetable) {
                    if (moduleTimetable.getName().equals(timeSlot.getRoom())) {
                        moduleTimetable.add(timeSlot);
                    }
                } else {
                    if (moduleTimetable.getName().equals(timeSlot.getModuleName())) {
                        moduleTimetable.add(timeSlot);
                    }
                }
            }
        }
    }

    public void addModuleToCourse(String courseName, String moduleName){
        for(ModuleTimetable course : this.courses){
            if(course.getName().equals(courseName)){
                CourseTimetable castedCourse = (CourseTimetable) course;
                castedCourse.addModule(getModule(moduleName));
                return;
            }
        }
    }

    public void addModuleToPerson(String name, String moduleName){
        for(User u : this.users){
            if(u.getUsername().equals(name)){
                Student castedUser = (Student) u;
                castedUser.addModule(getModule(moduleName));
                return;
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

    public ModuleTimetable getCourse(String courseName){
        for(ModuleTimetable m : this.courses){
            if(m.getName().equals(courseName)){
                return m;
            }
        }
        return null;
    }

    public ModuleTimetable getRoom(String roomName){
        for(ModuleTimetable m : this.rooms){
            if(m.getName().equals(roomName)){
                return m;
            }
        }
        return null;
    }

    public List<String[]> getAllModuleNames(){
        List<String[]> constructed = new ArrayList<>();
        for(ModuleTimetable m : this.modules){
            String[] codeName = new String[2];
            codeName[0] = m.getName();
            codeName[1] = names.get(m.getName());
            constructed.add(codeName);
        }
        return constructed;
    }

    public List<String[]> getAllCourseNames(){
        List<String[]> constructed = new ArrayList<>();
        for(ModuleTimetable m : this.courses){
            String[] codeName = new String[2];
            codeName[0] = m.getName();
            codeName[1] = names.get(m.getName());
            constructed.add(codeName);
        }
        return constructed;
    }

    public List<String[]> getAllRoomNames(){
        List<String[]> constructed = new ArrayList<>();
        for(ModuleTimetable m : this.rooms){
            String[] codeName = new String[2];
            codeName[0] = m.getName();
            codeName[1] = " ";
            constructed.add(codeName);
        }
        return constructed;
    }
}