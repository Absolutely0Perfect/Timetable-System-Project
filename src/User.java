class User{
    public enum UserType{
        student, lecturer, stuff, admin;

        public static  UserType getUserType(int i){
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
    }

    private String username;
    private String password;
    UserType type;

    User(String username, String password, int type){
        this.username = username;
        this.password = password;
        this.type = UserType.getUserType(type);
    }
}