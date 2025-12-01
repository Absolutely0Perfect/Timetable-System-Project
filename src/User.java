/**
 * <p> This is the class to make a login
 * Uses Usertype, password and username </p>
 */

class User {
    protected String username;
    protected String password;
    protected UserType userType;

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

    public boolean equals(String username, String password){
        return (this.username.equals(username)) && (this.password.equals(password));
    }

    @Override
    public String toString(){
        return username + "," + password + "," + userType.toInt();
    }
}