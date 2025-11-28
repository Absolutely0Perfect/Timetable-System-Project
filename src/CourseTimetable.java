import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>This class is to control any amount of timetables for certian Module tiemtables
 * This also communitcates with the view class to create a Course timetable</p>
 */
class  CourseTimetable extends ModuleTimetable{
    public CourseTimetable(String name, ModuleTimetable... times){
        super(name);
        for(ModuleTimetable m : times){
            this.times.addAll(m.getTimes());
        }
        Collections.sort(this.times);
    }

    public void addModule(ModuleTimetable module){
        this.times.addAll(module.getTimes());
        Collections.sort(this.times);
    }
}