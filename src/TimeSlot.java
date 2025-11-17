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
    String Lecturer;
    Day day;
    ClassType classType;

    public enum ClassType {
        LAB, LECTUER, TUTORIAL;

        public static  ClassType toClassType(int i) {
            return switch (i) {
                case 0 -> LAB;
                case 1 -> LECTUER;
                case 2 -> TUTORIAL;
                default -> null;
            };
        }

        public int toInt(ClassType t) {
            return switch (t) {
                case LAB -> 0;
                case LECTUER -> 1;
                case TUTORIAL -> 2;
            };
        }
    }


    public TimeSlot(String moduleName, String moduleDates, Day day, String hours, String room, ClassType classtype, String Lecturer) {
        this.moduleName = moduleName;
        this.moduleDates = moduleDates;
        this.day = day;
        this.hours = hours;
        this.room = room;
        this.classType = classType;
        this.Lecturer = Lecturer;
    }


    public String getmoduleName() {
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

    public String getLecturer() {return Lecturer;}

    public void setLecturer(String Lecturer) {this.Lecturer = Lecturer;}
}