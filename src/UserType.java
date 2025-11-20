/**
 * <p> enumerator of class User </p>
 */

public enum UserType {
    STUDENT, LECTURER, STAFF, ADMIN;

    public static  UserType toUserType(int i) {
        return switch (i) {
            case 0 -> STUDENT;
            case 1 -> LECTURER;
            case 2 -> STAFF;
            case 3 -> ADMIN;
            default -> null;
        };
    }
    
    public int toInt() {
        return switch (this) {
            case STUDENT -> 0;
            case LECTURER -> 1;
            case STAFF -> 2;
            case ADMIN -> 3;
        };
    }
}