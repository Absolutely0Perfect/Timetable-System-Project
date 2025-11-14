import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;

 class Module {
private final String moduleCode;
private final String type;
private final DayOfWeek day;
private final LocalTime start;
private final LocalTime end;
private final String room;

public Module(String moduleCode, String type, DayOfWeek day, LocalTime start, LocalTime end, String room){
    this.moduleCode = moduleCode;
    this.type = type;
    this.day = day;
    this.start= start;
    this.end = end;
    this.room = room;
}

     public DayOfWeek getDay() {
         return day;
     }

     public LocalTime getStart() {
         return start;
     }

     public LocalTime getEnd() {
         return end;
     }

     public String getModuleCode() {
         return moduleCode;
     }

     public String getRoom() {
         return room;
     }

     public String getType() {
         return type;
     }

     @Override
     public String toString(){
    return moduleCode + "" + type + "\nRoom:" + room;
     }
     static class ModuleTimetable{
    private List<Module> module = new ArrayList<>();

    public void Add(Module m){
        module.add(m);
    }
    public void Display(){
        DayOfWeek[] days = {DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY};
        LocalTime[] time = {LocalTime.of(9,0), LocalTime.of(12, 0), LocalTime.of(13, 0), LocalTime.of(15, 0)};
    }
// don't know how to actually display it in a grid format, I know you use displayGrid and probably printf but uh yeah
    private Module find(DayOfWeek day, LocalTime time){
        for(Module m : module){
            if(m.getDay() == day && m.getStart().equals(time)){
                return m;
            }
        }
        return null;
    }
    class TimeTableLayout{
        public static void main(String[] args){
           ModuleTimetable timetable = new ModuleTimetable();

           timetable.Add(new Module("CS4004", "Lab", DayOfWeek.THURSDAY, LocalTime.of(15, 0), LocalTime.of(16, 0), "CS1"));
           timetable.Add(new Module("CS4013", "Lec", DayOfWeek.WEDNESDAY, LocalTime.of(11, 0), LocalTime.of(12, 0), "CSG"));
           timetable.Add(new Module("CS4416", "Tut", DayOfWeek.WEDNESDAY, LocalTime.of(9, 0), LocalTime.of(10, 0), "CS2"));
           timetable.Add(new Module("CS4023", "Lec", DayOfWeek.TUESDAY, LocalTime.of(17, 0), LocalTime.of(18,0), "ERBG"));
           timetable.Add(new Module("CS4093", "Lec", DayOfWeek.THURSDAY, LocalTime.of(15, 0), LocalTime.of(17, 0), "HSGG"));

           //something to do with displayGrid, its probably just timetable.Display();
            timetable.Display();
            //ah it was awesomesauce.
        }
    }

  }
 }
