import java.util.ArrayList;
/**
 * <p> This also communicates with view to create a Timetable for Room and stores all relevent information about room </p>
 */
class RoomTimetable extends ModuleTimetable{
    RoomType type;
    int capacity;

    public RoomTimetable(String name, RoomType type, int capacity){
        super(name);
        this.type = type;
        this.capacity = capacity;
    }
}