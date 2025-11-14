class User {
    private String username;
    private String password;
    UserType userType;

    User(String username, String password, UserType userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public UserType getUserType(){
        return this.userType;
    }

    public boolean compare(String username, String password){
        return (this.username.equals(username)) && (this.password.equals(password));
    }
}