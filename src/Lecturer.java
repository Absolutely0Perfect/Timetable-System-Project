class Lecturer extends Student{
    protected name;

    public Lecturer(String username, String password, UserType userType, String name){
        super(username, password, userType);

        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}