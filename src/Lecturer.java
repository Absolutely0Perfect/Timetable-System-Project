class Lecturer extends Student{
    protected String name;

    public Lecturer(String username, String password, UserType userType, String name){
        super(username, password, userType);

        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        String lineForm = this.username + "," + this.password + "," + this.userType.toInt + "," + this.name;
        for(TimeSlot t: this.personalTimetable.getTimeSlots()){
            lineForm += "," + t.getModuleName();
        }
        return lineForm;
    }
}