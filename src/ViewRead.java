import java.util.List;

abstract class ViewRead{
    abstract public String selection(List<String[]> names);
    abstract public String[] displayLogin();
    abstract public int displayInterface(UserType userType);
    
    abstract public int editModuleTimetables();
    abstract public TimeSlotDTO[] editModuleTimeSlot(ViewRender viewRender, ModuleTimetable timetable, DataParser dataParser);
    abstract public List<TimeSlotDTO>[] editModuleLeader(ModuleTimetable timetable, DataParser dataParser);
    abstract public String[] addModuleTimeSlot();

    abstract public int editCourseTimetables();
    abstract public String[] editCourseModules();
    abstract public String[] addCourse();

    abstract public int editRooms();
    abstract public String[] editRoom();
    abstract public String[] addRoom();

    abstract public void exit();
}