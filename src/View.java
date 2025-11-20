/**
 * <p>Displays infomration to user based on inputs folowing Usertype </p>
 */

abstract class View {
    abstract public void exit();
    abstract public void displayTimetable(ModuleTimetable module);
    abstract public int displayInterface(UserType userType);
    abstract public String[] displayLogin();
}