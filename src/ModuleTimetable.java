import java.util.ArrayList;
import java.util.Collections;
/**
 * <p>This gathers the nessecary information to create a Modulue it also communicates with the view class </p>
 */
class ModuleTimetable {
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