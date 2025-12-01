/**
 * <p>This class holds all the CSV Files that the data is inputed to <p>
 */
import java.io.File;
import java.nio.file.Path;

class Data{
    protected File userData;
    protected File roomData;
    protected File modulesData;
    protected File coursesData;
    protected File namesData;
    protected Path userPath;
    protected Path roomPath;
    protected Path modulesPath;
    protected Path coursesPath;
    protected Path namesPath;
    private Path path;
    /**
     * <p>This method is used to make it easier to connect to the files <p>
     */
    public Data(){
        if (!new File("./Data").exists()) {
            if(new File("../Data").exists()){
                path = Path.of("../Data");
            }
        } else {
            path = Path.of("./Data");
        }
        assert path != null;
        String a = path.toAbsolutePath().toString() + "/users.csv";
        userPath = Path.of(a);
        a = userPath.toAbsolutePath().toString();
        this.userData = new File(a);

        a = path.toAbsolutePath().toString() + "/modules.csv";
        modulesPath = Path.of(a);
        a = modulesPath.toAbsolutePath().toString();
        this.modulesData = new File(a);

        a = path.toAbsolutePath().toString() + "/rooms.csv";
        roomPath = Path.of(a);
        a = roomPath.toAbsolutePath().toString();
        this.roomData = new File(a);

        a = path.toAbsolutePath().toString() + "/courses.csv";
        coursesPath = Path.of(a);
        a = coursesPath.toAbsolutePath().toString();
        this.coursesData = new File(a);

        a = path.toAbsolutePath().toString() + "/names.csv";
        namesPath = Path.of(a);
        a = namesPath.toAbsolutePath().toString();
        this.namesData = new File(a);
        
    }
}