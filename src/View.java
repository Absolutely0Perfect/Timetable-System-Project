/**
 * Displays infomration to user based on inputs folowing Usertype
 */

abstract class View {
    abstract public void exit();
    abstract public void displayTimetable();
    abstract public int displayInterface(UserType userType);
    abstract public String[] displayLogin();
}