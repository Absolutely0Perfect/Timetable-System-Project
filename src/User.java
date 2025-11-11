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

        public int toInt(UserType t) {
            return switch (t) {
                case student -> 0;
                case lecturer -> 1;
                case staff -> 2;
                case admin -> 3;
            };
        }
    }

    private String username;
    private String password;
    UserType type;

    User(String username, String password, int type) {
        this.username = username;
        this.password = password;
        this.type = UserType.toUserType(type);
    }
}