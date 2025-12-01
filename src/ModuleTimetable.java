import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 * <p>This gathers the necessary information to create a Module, it also communicates with the view class </p>
 */
public class ModuleTimetable {
    String name;
    List<TimeSlot> timeSlots;

    public ModuleTimetable(String name){
        this.name = name;
        this.timeSlots = new ArrayList<>();
    }

    public void add(TimeSlot timeSlot){
        this.timeSlots.add(timeSlot);
        Collections.sort(this.timeSlots);
    }
    /**
     * <p>Method gets a timeslot then removes it <p>
     */
    public void remove(int start){
        for(int i = 0; i < this.timeSlots.size(); i++){
            if(this.timeSlots.get(i).getStart() == start){
                this.timeSlots.remove(i);
                return;
            }
        }
    }
    /**
     * <p>Method checks if timeslot is free <p>
     */
    public boolean isSlotFree(int start, int end, Day day){
        int tStart, tEnd;
        Day tDay;
        for(TimeSlot t : this.timeSlots){
            tStart = t.getStart();
            tEnd = t.getEnd();
            tDay = t.getDay();

            if(tDay != day){
                continue;
            }

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
        Day day = timeSlot.getDay();
        int tStart, tEnd;
        Day tDay;
        for(TimeSlot t : this.timeSlots){
            tStart = t.getStart();
            tEnd = t.getEnd();
            tDay = t.getDay();

            if(tDay != day){
                continue;
            }

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

    public List<TimeSlot> getTimeSlots() {
        return this.timeSlots;
    }

    public String getName(){
        return this.name;
    }
}