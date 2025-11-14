//import java.time.DayOfWeek; we alrea have an enum for it
//import java.util.*; // legendary))
import java.time.LocalTime;
import java.util.LinkedList;

// Module calss was just a copy of Cians TimeSlot, redundant

class ModuleTimetable{
    private LinkedList<TimeSlot> module;

    public ModuleTimetable(){
        module = new LinkedList<>();
    }

    public void Add(TimeSlot timeSlot){
        module.add(timeSlot);
    }
}
