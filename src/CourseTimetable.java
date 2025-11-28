import java.util.ArrayList;

/**
 * <p>This class is to control any amount of timetables for certian Module tiemtables
 * This also communitcates with the view class to create a Course timetable</p>
 */
class  CourseTimetable extends ModuleTimetable{
    private ArrayList<ModuleTimetable> modules;

    public CourseTimetable(ModuleTimetable... modules){
        this.modules = new ArrayList<>();
        for(ModuleTimetable m : modules){
            modules.addAll(m);
        }
    }

    public addModule()
}