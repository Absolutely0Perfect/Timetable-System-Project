import java.util.ArrayList;

class TimeSlot {
    String moduleName;
    String moduleDates;
    String hours;
    String room;
    String classtype;
    String Lecturer;
    Day day;
    ClassType classType;

    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

        public static  Day toDay(int i) {
            return switch (i) {
                case 0 -> MONDAY;
                case 1 -> TUESDAY;
                case 2 -> WEDNESDAY;
                case 3 -> THURSDAY;
                case 4 -> FRIDAY;
                case 5 -> SATURDAY;
                case 6 ->  SUNDAY;
                default -> null;
            };
        }

        public int toInt(Day t) {
            return switch (t) {
                case MONDAY -> 0;
                case TUESDAY -> 1;
                case WEDNESDAY -> 2;
                case THURSDAY -> 3;
                case FRIDAY -> 4;
                case SATURDAY -> 5;
                case SUNDAY -> 6;
            };
        }
    }

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

    public String getmoduleDates() {return moduleDates;}

    public void setModuleDates(String moduleDates) {this.moduleDates = moduleDates;}

    public String getHours() {return hours;}

    public void setHours(String hours) {this.hours = hours;}

    public String getRoom() {return room;}

    public void setRoom(String room) {this.room = room;}

    public String getLecturer() {return Lecturer;}

    public void setLecturer(String Lecturer) {this.Lecturer = Lecturer;}
}