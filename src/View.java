import java.util.ArrayList;
/**
 * <p>Displays information to user based on inputs following Usertype</p>
 */
abstract class View {
    abstract public void exit();
    abstract public String moduleSelection(ArrayList<String> names);
    abstract public void displayTimetable(ModuleTimetable module);
    abstract public int displayInterface(UserType userType);
    abstract public String[] displayLogin();
    abstract public String[] editModuleTimetableLine();
    abstract public String[] editCourseTimetableLine();
    abstract public String[] editRoomTimetableLine();
}