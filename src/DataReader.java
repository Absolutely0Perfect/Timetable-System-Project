import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/**
 * <p> This class reads and stores data from other classes
 * takes the information and gives it to other classes
 * it also takes the information and creates new informaiton with it </p>
 */
class DataReader extends Data{
    public DataReader(){
        super();
    }

    public List<User> readUserData(List<ModuleTimetable> modules){
        List<User> users = new ArrayList<>();

        try (Scanner scanner = new Scanner(this.userData)){

            String curentLine;
            String splitLine[];
            String username;
            String password;
            String module;
            String name;
            UserType userType;

            while(scanner.hasNext()){
                curentLine = scanner.next();
                splitLine = curentLine.split(",");

                username = splitLine[0];
                password = splitLine[1];
                userType = UserType.toUserType(Integer.parseInt(splitLine[2]));

                switch (userType){
                case STUDENT:
                    users.add(new Student(username, password, userType));
                    for(int i = 3; i < splitLine.length; i++){
                        addModuleToPerson(username, splitLine[i], modules, users);
                    }
                    break;
                case LECTURER:
                    name = splitLine[3];
                    users.add(new Lecturer(username, password, userType, name));
                    for(int i = 4; i < splitLine.length; i++){
                        addModuleToPerson(username, splitLine[i], modules, users);
                    }
                    break;
                case ADMIN:
                    users.add(new Student(username, password, userType));
                    break;
                }
            }
        }
        catch(FileNotFoundException e){
            IO.println("File not found");
        }
        return users;
    }

    public List<ModuleTimetable> readRoomData(){
        List<ModuleTimetable> rooms = new ArrayList<>();

        try (Scanner scanner = new Scanner(this.roomData)){

            String curentLine;
            String splitLine[];
            String roomName;
            int roomType;
            int capacity;

            while(scanner.hasNext()){
                curentLine = scanner.next();
                splitLine = curentLine.split(",");

                roomName = splitLine[0];
                roomType = Integer.parseInt(splitLine[1]);
                capacity = Integer.parseInt(splitLine[2]);

                rooms.add(new RoomTimetable(roomName, RoomType.toRoomType(roomType), capacity));
            }
        }
        catch(FileNotFoundException e){
            IO.println("File not found");
        }
        return rooms;
    }

    public List<ModuleTimetable> readModuleData(List<ModuleTimetable> rooms){
        List<ModuleTimetable> modules = new ArrayList<>();

        try (Scanner scanner = new Scanner(this.modulesData)){

            String curentLine;
            String splitLine[];
            TimeSlotDTO timeSlotDTO;

            while(scanner.hasNext()){
                curentLine = scanner.next();
                splitLine = curentLine.split(",");

                timeSlotDTO = new TimeSlotDTO(splitLine);
                
                if(!findModule(timeSlotDTO.moduleName, modules)){
                    modules.add(new ModuleTimetable(timeSlotDTO.moduleName));
                }
                
                addTimeSlot(new TimeSlot(timeSlotDTO), modules, rooms);
            }
        }
        catch(FileNotFoundException e){
            IO.println("File not found");
        }

        return modules;
    }

    public List<ModuleTimetable> readCourseData(List<ModuleTimetable> modules){
        List<ModuleTimetable> courses = new ArrayList<>();

        try (Scanner scanner = new Scanner(this.coursesData)){

            String curentLine;
            String splitLine[];
            String courseCode;
            String module;

            while(scanner.hasNext()){
                curentLine = scanner.next();
                splitLine = curentLine.split(",");

                courseCode = splitLine[0];
                courses.add(new CourseTimetable(courseCode));

                for(int i = 1; i < splitLine.length; i++){
                    addModuleToCourse(courseCode, splitLine[i], modules, courses);
                }
            }
        }
        catch(FileNotFoundException e){
            IO.println("File not found");
        }
        return courses;
    }

    public Map<String, String> readNamesData(){
        Map<String, String> names = new HashMap<>();

        try (Scanner scanner = new Scanner(this.coursesData)){

            String curentLine;
            String splitLine[];

            while(scanner.hasNext()){
                curentLine = scanner.next();
                splitLine = curentLine.split(",");

                names.put(splitLine[0], splitLine[1]);
            }
        }
        catch(FileNotFoundException e){
            IO.println("File not found");
        }
        return names;
    }

    private void addTimeSlot(TimeSlot timeSlot, List<ModuleTimetable>... timetables){
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

    private void addModuleToCourse(String courseName, String moduleName, List<ModuleTimetable> modules, List<ModuleTimetable> courses){
        for(ModuleTimetable course : courses){
            if(course.getName().equals(courseName)){
                CourseTimetable castedCourse = (CourseTimetable) course;
                for(ModuleTimetable module : modules){
                    if(module.getName().equals(moduleName)){
                        castedCourse.addModule(module);
                    }
                }
                return;
            }
        }
    }

    private void addModuleToPerson(String name, String moduleName, List<ModuleTimetable> modules, List<User> users){
        for(User u : users){
            if(u.getUsername().equals(name)){
                Student castedUser = (Student) u;
                for(ModuleTimetable module : modules){
                    if(module.getName().equals(moduleName)){
                        castedUser.addModule(module);
                    }
                }
                return;
            }
        }
    }

    private boolean findModule(String name, List<ModuleTimetable> modules){
        for(ModuleTimetable m : modules){
            if(m.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}