/**
 * <p>This class is an enumerator for each Type of class </p>
 */
public enum ClassType {
    LEC, LAB, TUT;
    public static  ClassType toClassType(int i) {
        return switch (i) {
            case 0 -> LEC;
            case 1 -> LAB;
            case 2 -> TUT;
            default -> null;
        };
    }
    public int toInt() {
        return switch (this) {
            case LEC -> 0;
            case LAB -> 1;
            case TUT -> 2;
        };
    }
}