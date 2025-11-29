import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>This class is to control any amount of timetables for certain Module timetables.
 * This also communicates with the view class to create a Course timetable</p>
 */
class  CourseTimetable extends ModuleTimetable{
    public CourseTimetable(String name, ModuleTimetable... times){
        super(name);
        for(ModuleTimetable m: times){
            this.timeSlots.addAll(m.getTimeSlots());
        }
        Collections.sort(this.timeSlots);
    }

    public void addModule(ModuleTimetable module){
        this.timeSlots.addAll(module.getTimeSlots());
        Collections.sort(this.timeSlots);
    }
}