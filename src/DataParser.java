import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class DataParser{
    private DataReader dataReader;
    private List<User> users;
    private List<ModuleTimetable> rooms;
    private List<ModuleTimetable> modules;
    private List<ModuleTimetable> courses;
    private Map<String, String> names;
    private Set<String> lecturers;

    public DataParser(){
        dataReader = new DataReader();
        lecturers = new HashSet<>();

        this.rooms = dataReader.readRoomData();
        this.modules = dataReader.readModuleData(this.rooms);
        this.users = dataReader.readUserData(this.modules, this.lecturers);
        this.courses = dataReader.readCourseData(this.modules);
        this.names = dataReader.readNamesData();
    }

    public void reload(){
        this.users.clear();
        this.rooms.clear();
        this.modules.clear();
        this.courses.clear();
        this.names.clear();
        this.lecturers.clear();

        this.rooms = dataReader.readRoomData();
        this.modules = dataReader.readModuleData(this.rooms);
        this.users = dataReader.readUserData(this.modules, this.lecturers);
        this.courses = dataReader.readCourseData(this.modules);
        this.names = dataReader.readNamesData();
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

    public boolean isLecturerPresent(String name){
        return this.lecturers.contains(name);
    }
}