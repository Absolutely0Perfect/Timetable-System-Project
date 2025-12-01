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

    public TimeSlot(TimeSlotDTO timeSlotDTO) {
        this.moduleName = timeSlotDTO.moduleName;
        this.moduleDates = timeSlotDTO.moduleDates;
        this.day = Day.toDay(Integer.parseInt(timeSlotDTO.day));
        this.start = Integer.parseInt(timeSlotDTO.start);
        this.end = Integer.parseInt(timeSlotDTO.end);
        this.room = timeSlotDTO.room;
        this.classType = ClassType.toClassType(Integer.parseInt(timeSlotDTO.classType));
        this.lecturer = timeSlotDTO.lecturer;
    }

    /**
     * <p>Getters and setters for data in Timeslot <p>
     */
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
    /**
     * <p>This Override Method converts the enuemerators to ints
     * This makes it easier to use them to be used when its propted for the user</p>
     */
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
    /**
     * <p>Method calls from class TimeslotDTO <p>
     */
    public TimeSlotDTO toDTO(){
        String[] line = {this.moduleName, this.moduleDates, "" + this.day.toInt(), 
            "" + this.start, "" + this.end, this.room, "" + this.classType.toInt(), this.lecturer};
        return new TimeSlotDTO(line);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        TimeSlot cloned = (TimeSlot) super.clone();
        return cloned;
    }
}