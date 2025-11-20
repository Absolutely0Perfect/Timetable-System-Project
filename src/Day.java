/**
 * <p> This class is an enumerator for the days of the week</p>
 */
public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

        public static  Day toDay(int i) {
            return switch (i) {
                case 1 -> MONDAY;
                case 2 -> TUESDAY;
                case 3 -> WEDNESDAY;
                case 4 -> THURSDAY;
                case 5 -> FRIDAY;
                case 6 -> SATURDAY;
                case 7 ->  SUNDAY;
                default -> null;
            };
        }

        public int toInt() {
            return switch (this) {
                case MONDAY -> 1;
                case TUESDAY -> 2;
                case WEDNESDAY -> 3;
                case THURSDAY -> 4;
                case FRIDAY -> 5;
                case SATURDAY -> 6;
                case SUNDAY -> 7;
            };
        }
    }