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
        this.personalTimetable.add(timeSlot);
    }

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