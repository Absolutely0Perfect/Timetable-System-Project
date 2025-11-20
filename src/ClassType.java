public enum ClassType {
    LECTUER, LAB, TUTORIAL;
    public static  ClassType toClassType(int i) {
        return switch (i) {
            case 0 -> LECTUER;
            case 1 -> LAB;
            case 2 -> TUTORIAL;
            default -> null;
        };
    }
    public int toInt() {
        return switch (this) {
            case LECTUER -> 0;
            case LAB -> 1;
            case TUTORIAL -> 2;
        };
    }
}