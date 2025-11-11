class User{
    public enum UserType{
        student, lecturer, stuff, admin;

        public static  UserType toUserType(int i){
            switch(i){
            case 0:
                return student;
            case 1:
                return lecturer;
            case 2:
                return  stuff;
            case 3:
                return admin;
            }
            return null;
        }

        public int toInt(){
            switch(this){
            case student:
                return 0;
            case lecturer:
                return 1;
            case stuff:
                return 2;
            case admin:
                return 3;
            }
            return -1;
        } 
    }

    private String username;
    private String password;
    private UserType type;

    User(String username, String password, int type){
        this.username = username;
        this.password = password;
        this.type = UserType.toUserType(type);
    }

    //debuging stuff
    public void printInfo(){
        IO.println(this.username + " " + this.password + " " + this.type.toInt());
    }
}