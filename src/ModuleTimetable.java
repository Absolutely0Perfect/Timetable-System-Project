import java.util.ArrayList;
import java.util.Collections;
/**
 * <p>This gathers the necessary information to create a Module, it also communicates with the view class </p>
 */
public class ModuleTimetable {
    String name;
    ArrayList<TimeSlot> timeSlots;

    public ModuleTimetable(String name){
        this.name = name;
        this.timeSlots = new ArrayList<>();
    }

    public void add(TimeSlot timeSlot){
        this.timeSlots.add(timeSlot);
        Collections.sort(this.timeSlots);
    }

    public ArrayList<TimeSlot> getTimeSlots() {
        return this.timeSlots;
    }

    public String getName(){
        return this.name;
    }
}