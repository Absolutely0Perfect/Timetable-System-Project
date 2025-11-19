import java.util.ArrayList;

/**
 * <p>This Class stores any nessecary infomartion to create a cell for Timetable </p>
 */
class TimeSlot {
    String moduleName;
    String moduleDates;
    String hours;
    String room;
    String classtype;
    String lecturer;
    Day day;
    ClassType classType;

    public TimeSlot(String moduleName, String moduleDates, Day day, String hours, String room, ClassType classType, String lecturer) {
        this.moduleName = moduleName;
        this.moduleDates = moduleDates;
        this.day = day;
        this.hours = hours;
        this.room = room;
        this.classType = classType;
        this.lecturer = lecturer;
    }


    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleDates() {return moduleDates;}

    public void setModuleDates(String moduleDates) {this.moduleDates = moduleDates;}

    public String getHours() {return hours;}

    public void setHours(String hours) {this.hours = hours;}

    public String getRoom() {return room;}

    public void setRoom(String room) {this.room = room;}

    public String getLecturer() {return lecturer;}

    public void setLecturer(String lecturer) {this.lecturer = lecturer;}
}