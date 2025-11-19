//import java.time.DayOfWeek; we alrea have an enum for it
//import java.util.*; // legendary))
import java.time.LocalTime;
import java.util.LinkedList;

/**
 * <p>This gathers the nessecary information to create a Modulue it also communicates with the view class </p>
 */
// Module calss was just a copy of Cians TimeSlot, redundant

class ModuleTimetable{
    private String name;
    private LinkedList<TimeSlot> moduleTimes;

    public ModuleTimetable(String name){
        this.name = name;
        moduleTimes = new LinkedList<>();
    }

    public void add(TimeSlot timeSlot){
        moduleTimes.add(timeSlot);
    }

    public String getName(){
        return this.name;
    }
}
