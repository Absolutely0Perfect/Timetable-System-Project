/**
 * This class is an enumerator for the days of the week
 */
public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

        public static  Day toDay(int i) {
            return switch (i) {
                case 0 -> MONDAY;
                case 1 -> TUESDAY;
                case 2 -> WEDNESDAY;
                case 3 -> THURSDAY;
                case 4 -> FRIDAY;
                case 5 -> SATURDAY;
                case 6 ->  SUNDAY;
                default -> null;
            };
        }

        public int toInt(Day t) {
            return switch (t) {
                case MONDAY -> 0;
                case TUESDAY -> 1;
                case WEDNESDAY -> 2;
                case THURSDAY -> 3;
                case FRIDAY -> 4;
                case SATURDAY -> 5;
                case SUNDAY -> 6;
                default -> null;
            };
        }
    }