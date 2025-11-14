// most of this file was completely redunant
//import java.util.*; //Legendary
import java.util.LinkedList;

class  CourseTimetable {
    private LinkedList<ModuleTimetable> modules;

    public CourseTimetable(ModuleTimetable... modules){
        this.modules = new LinkedList<>();
        for(ModuleTimetable m : modules){
            modules.add(m);
        }
    }
}