/**
 * <p>This class holds all the CSV Files that the data is inputed to <p>
 */
import java.io.File;

class Data{
    protected File userData;
    protected File roomData;
    protected File modulesData;
    protected File coursesData;
    protected File namesData;
    /**
     * <p>This method is used to make it easier to connect to the files <p>
     */
    public Data(){
        this.userData = new File("../Data/users.csv");
        this.modulesData = new File("../Data/modules.csv");
        this.roomData = new File("../Data/rooms.csv");
        this.coursesData = new File("../Data/courses.csv");
        this.namesData = new File("../Data/names.csv");
    }
}