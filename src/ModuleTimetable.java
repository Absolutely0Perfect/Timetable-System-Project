//import java.time.DayOfWeek; we alrea have an enum for it
//import java.util.*; // legendary))
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
/**
 * <p>This gathers the nessecary information to create a Modulue it also communicates with the view class </p>
 */
// Module calss was just a copy of Cians TimeSlot, redundant

class ModuleTimetable {
    String name;
    ArrayList<TimeSlot> times;

    public ModuleTimetable(String name){
        this.name = name;
        this.times = new ArrayList<>();
    }

    public void add(TimeSlot timeSlot){
        this.times.add(timeSlot);
        Collections.sort(this.times);
    }

    public ArrayList<TimeSlot> getTimes() {
        return this.times;
    }

    public String getName(){
        return this.name;
    }
}