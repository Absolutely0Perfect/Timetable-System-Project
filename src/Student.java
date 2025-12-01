/**
 * <p>This class holds all the information for student <p>
 */
class Student extends User{
    protected CourseTimetable personalTimetable;
    /**
     * <p>constructor for student <p>
     */
    public Student(String username, String password, UserType userType){
        super(username, password, userType);

        this.personalTimetable = new CourseTimetable(username);
    }
    /**
     * <p>This gets student information for their personal timetable <p>
     */
    public CourseTimetable getPersonalTimetable(){
        return this.personalTimetable;
    }
    /**
     * <p>Method to add a students class to timeslot <p>
     */
    public void addTimeSlot(TimeSlot timeSlot){
        this.personalTimetable.add(timeSlot);
    }
    /**
     * <p>Adds all classes and lectures for a module to student timetable <p>
     */
    public void addModule(ModuleTimetable module){
        this.personalTimetable.addModule(module);
    }

    @Override
    public String toString(){
        String lineForm = this.username + "," + this.password + "," + this.userType.toInt();
        for(TimeSlot t: this.personalTimetable.getTimeSlots()){
            lineForm += "," + t.getModuleName();
        }
        return lineForm;
    }
}