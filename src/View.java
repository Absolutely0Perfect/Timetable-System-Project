import java.util.List;
/**
 * <p>Displays information to user based on inputs following Usertype</p>
 */
abstract class View {
    abstract public void exit();

    abstract public String selection(List<String[]> names);
    abstract public String[] displayLogin();
    abstract public int displayInterface(UserType userType);
    abstract public void displayTimetable(ModuleTimetable module);

    abstract public int editModuleTimetables();
    abstract public String[] edditModuleTimeSlot(ModuleTimetable timetable);
    abstract public String[] addModuleTimeSlot();

    abstract public int editCourseTimetables();
    abstract public String[] editCourseModules();
    abstract public String[] addCourse();

    abstract public int editRooms();
    abstract public String[] editRoom();
    abstract public String[] addRoom();
}