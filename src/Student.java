class Student extends User{
    protected CourseTimetable personalTimetable;

    public Student(String username, String password, UserType userType){
        super(username, password, userType);

        this.personalTimetable = new CourseTimetable(username);
    }

    public CourseTimetable getPersonalTimetable(){
        return this.personalTimetable;
    }

    public void addTimeSlot(TimeSlot timeSlot){
        this.studentTimetable.add(timeSlot);
    }

    public void addModule(ModuleTimetable module){
        this.studentTimetable.addModule(module);
    }
}