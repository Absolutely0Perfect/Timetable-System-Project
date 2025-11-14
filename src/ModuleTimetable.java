// import java.time.DayOfWeek; we alrea have an enum for it
import java.time.LocalTime;
import java.util.LinkedList;
//import java.util.*; // legendary))

// Module calss was just a copy of Cians TimeSlot, redundant

class ModuleTimetable{
    private LinkedList<TimeSlot> module;

    public ModuleTimetable(){
        module = new LinkedList<>();
    }

    public void Add(TimeSlot timeSlot){
        module.add(timeSlot);
    }

    /*private TimeSlot find(DayOfWeek day, LocalTime time){ // do we need it?
        for(TimeSlot m : module){
            if(m.getDay() == day && m.getStart().equals(time)){
                return m;
            }
        }
        return null;
    } */
    /*class TimeTableLayout{ Completely redundant
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
    }*/
}
