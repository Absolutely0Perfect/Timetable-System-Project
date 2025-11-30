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

    abstract public String[] editModuleTimetableLine();
    abstract public String[] editCourseTimetableLine();
    abstract public String[] editRoomTimetableLine();
}