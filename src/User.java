class User {
    public enum UserType {
        student, lecturer, staff, admin;

        public static  UserType toUserType(int i) {
            return switch (i) {
                case 0 -> student;
                case 1 -> lecturer;
                case 2 -> staff;
                case 3 -> admin;
                default -> null;
            };
        }

<<<<<<< Updated upstream
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
=======
        public int toInt(UserType t) {
            return switch (t) {
                case student -> 0;
                case lecturer -> 1;
                case staff -> 2;
                case admin -> 3;
            };
        }
>>>>>>> Stashed changes
    }

    private String username;
    private String password;
    private UserType type;

    User(String username, String password, int type) {
        this.username = username;
        this.password = password;
        this.type = UserType.toUserType(type);
    }

    //debuging stuff
    public void printInfo(){
        IO.println(this.username + " " + this.password + " " + this.type.toInt());
    }
}