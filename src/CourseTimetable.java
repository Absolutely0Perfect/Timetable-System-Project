import java.util.*;
import java.time.DayOfWeek;
import java.time.LocalTime;



 class Course {
    private String type;
    private DayOfWeek day;
    private LocalTime start;
    private LocalTime end;
    private String room;
    private String lecturer;

    public Course(String type, DayOfWeek day, LocalTime start, LocalTime end, String room, String lecturer){
        this.type = type;
        this.day = day;
        this.start = start;
        this.end = end;
        this.room = room;
        this.lecturer = lecturer;
    }

     public DayOfWeek getDay() {
         return day;
     }

     public LocalTime getEnd() {
         return end;
     }

     public LocalTime getStart() {
         return start;
     }

     @Override
     public String toString(){
        return String.format("%-10s | %-9s | %s - %s | Room: %-6s | Lecturer: %s", type, day, start, end, room, lecturer);
     }
 }
 class Modules {
     private String code;
     private String title;
     private List<Course> courses;

     public Modules(String code, String title) {
         this.code = code;
         this.title = title;
         this.courses = new ArrayList<>();
     }

     public void Add(String type, DayOfWeek day, LocalTime start, LocalTime end, String room, String lecturer) {
         courses.add(new Course(type, day, start, end, room, lecturer));
     }

     public List<Course> getCourses() {
         return courses;
     }

     public String getCode() {
         return code;
     }

     public String getTitle() {
         return title;
     }

     @Override
     public String toString() {
         return code + " - " + title + " .";
     }
 }
    class  CourseTimetable {
        private String name;
        private List<Modules> modules;


        public void CourseTimetable(String name) {
            this.name = name;
            this.modules = new ArrayList<>();
        }

        public void add(Modules module){
            modules.add(module);
        }

        public void show(){
            System.out.println("\n----- TimeTable " + "-----\n");

          // something else should go here but I dont what to put here, but we shall figure it out
        }
 }
        class Timetable {
    public static void main(String[] args) {
        CourseTimetable course = new CourseTimetable();

        Modules cs4013 = new Modules("Cs4013", "Obeject Orientated Development");
        cs4013.Add("Lec", DayOfWeek.THURSDAY, LocalTime.of(9, 0), LocalTime.of(10, 0), "CSG", "Dr. Michael English");
        cs4013.Add("Lab", DayOfWeek.FRIDAY, LocalTime.of(11, 0), LocalTime.of(13, 0), "CS1", "Dr. Michael English");

        Modules cs4023 = new Modules("Cs4023", "Operating Systems");
        cs4023.Add("Lec", DayOfWeek.TUESDAY, LocalTime.of(10, 0), LocalTime.of(11, 0), "C1", "Dr. Emil Vassev");
        cs4023.Add("Tut", DayOfWeek.FRIDAY, LocalTime.of(13, 0), LocalTime.of(14, 0), "ERBG", "Dr. Emil Vassev");

        Modules cs4416 = new Modules("Cs4416", "Database Systems");
        cs4416.Add("Lec", DayOfWeek.WEDNESDAY, LocalTime.of(12, 0), LocalTime.of(13, 0), "HSGG", "Dr Nikola Nikolov");


    }
}

