import java.util.ArrayList;
/**
 * <p> This also communicates with view to create a Timetable for Room and stores all relevent information about room </p>
 */
class RoomTimetable extends ModuleTimetable{
    RoomType type;
    int capacity;

    public RoomTimetable(String name, RoomType type, int capacity){
        super(name);
        this.type = type;
        this.capacity = capacity;
    }

    public boolean isSlotFree(int start, int end){
        int tStart, tEnd;
        for(TimeSlot t : this.timeSlots){
            tStart = t.getStart();
            tEnd = t.getEnd();

            if(tStart == start){
                return false;
            }
            else if(tStart < start && tEnd > start){
                return false;
            }
            else if(tStart < end && tEnd > end){
                return false;
            }
        }
        return true;
    }

    public boolean isSlotFree(TimeSlot timeSlot){
        int start = timeSlot.getStart();
        int end = timeSlot.getEnd();
        int tStart, tEnd;
        for(TimeSlot t : this.timeSlots){
            tStart = t.getStart();
            tEnd = t.getEnd();

            if(tStart == start){
                return false;
            }
            else if(tStart < start && tEnd > start){
                return false;
            }
            else if(tStart < end && tEnd > end){
                return false;
            }
        }
        return true;
    }
}