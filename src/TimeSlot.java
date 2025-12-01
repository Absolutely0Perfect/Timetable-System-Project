import java.util.ArrayList;

/**
 * <p>This Class stores any nessecary infomartion to create a cell for Timetable </p>
 */
class TimeSlot implements Comparable<TimeSlot>, Cloneable{
    String moduleName;
    String moduleDates;
    Day day;
    int start;
    int end;
    String room;
    ClassType classType;
    String lecturer;

    public TimeSlot(String moduleName, String moduleDates, Day day, int start, int end, String room, ClassType classType, String lecturer) {
        this.moduleName = moduleName;
        this.moduleDates = moduleDates;
        this.day = day;
        this.start = start;
        this.end = end;
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

    public Day getDay(){
        return this.day;
    }

    public void setDay(Day day){
        this.day = day;
    }
    
    public void setStart(int start){
        this.start = start;
    }

    public void setEnd(int end){
        this.end = end;
    }

    public String getModuleDates() {return moduleDates;}

    public void setModuleDates(String moduleDates) {this.moduleDates = moduleDates;}

    public ClassType getClassType(){return classType;}

    public int getStart() {return start;}

    public int getEnd() {return end;}

    public String getRoom() {return room;}

    public void setRoom(String room) {this.room = room;}

    public String getLecturer() {return lecturer;}

    public void setLecturer(String lecturer) {this.lecturer = lecturer;}

    @Override
    public int compareTo(TimeSlot timeSlot){
        if(this.start == timeSlot.getStart()){
            if(this.day == timeSlot.getDay()){
                return 0;
            }
            else if(this.day.toInt() < timeSlot.getDay().toInt()){
                return -1;
            }
            else{
                return 1;
            }
        }
        else if(this.start < timeSlot.getStart()){
            return -1;
        }
        else{
            return 1;
        }
    }

    @Override
    public String toString(){
        return moduleName + "," + moduleDates + "," + day.toInt() + "," + start + "," + end + "," + room + "," + classType.toInt() + "," + lecturer;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        TimeSlot cloned = (TimeSlot) super.clone();
        return cloned;
    }
}