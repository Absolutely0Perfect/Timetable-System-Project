class User {
    private String username;
    private String password;
    UserType type;

    User(String username, String password, UserType userType) {
        this.username = username;
        this.password = password;
        this.type = userType;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public boolean compare(String username, String password){
        return (this.username.equals(username)) && (this.password.equals(password));
    }
}