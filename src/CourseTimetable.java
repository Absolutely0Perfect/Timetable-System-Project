// most of this file was completely redunant
//import java.util.*; //Legendary
import java.util.LinkedList;

/**
 * <p>This class is to control any amount of timetables for certian Module tiemtables
 * This also communitcates with the view class to create a Course timetable</p>
 */
class  CourseTimetable {
    private LinkedList<ModuleTimetable> modules;

    public CourseTimetable(ModuleTimetable... modules){
        this.modules = new LinkedList<>();
        for(ModuleTimetable m : modules){
            modules.add(m);
        }
    }
}