import java.util.ArrayList;

class Module {
    String moduleName;
    String moduleDates;
    String day;
    String hours;
    String room;
    String classtype;
    String Lecturer;

    public Module(String moduleName, String moduleDates, String day, String hours, String room, String classtype, String Lecturer) {
        this.moduleName = moduleName;
        this.moduleDates = moduleDates;
        this.day = day;
        this.hours = hours;
        this.room = room;
        this.classtype = classtype;
        this.Lecturer = Lecturer;
    }


    public String getmoduleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getmoduleDates() {return moduleDates;}

    public void setModuleDates(String moduleDates) {this.moduleDates = moduleDates;}

    public String getDay() {return day;}

    public void setDay(String day){this.day = day;}

    public String getHours() {return hours;}

    public void setHours(String hours) {this.hours = hours;}

    public String getRoom() {return room;}

    public void setRoom(String room) {this.room = room;}

    public String getClasstype() {return classtype;}

    public void setClasstype(String classtype) {this.classtype = classtype;}

    public String getLecturer() {return Lecturer;}

    public void setLecturer(String Lecturer) {this.Lecturer = Lecturer;}
}