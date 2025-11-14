class Booking {
    private int start; // maybe we can just use int?
    private int end;
    private Day day;
    private int week;
    //private String description; // wtf is description?

    public Booking(int start, int end, Day day, int week){
        this.start = start;
        this.end = end;
        this.day = day;
        this.week = week;
    }

    public boolean doubleBooked(Booking booking){
        if(this.day == booking.getDay() && this.week == booking.getWeek()){
            return checkIfOverlapsOnDay(booking);
        }
        return false;
    }

    private boolean checkIfOverlapsOnDay(Booking booking){
        if(this.start >= booking.getStart()){
            if(this.end > booking.getStart()){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return "starts at" + start + "ends at" + end + "\n on " + day + " of week " + week;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd(){
        return this.end;
    }

    public Day getDay(){
        return this.day;
    }

    public int getWeek(){
        return this.week;
    }
}

/*class RoomTimetable{ absolutely redundant for now
    public static void main(String[] args){ // wa already have main
        Rooms rm1 = new Bookings.Rooms("csg");

        LocalDateTime start = LocalDateTime.of(2025, 11, 14, 9, 0);
        LocalDateTime end = LocalDateTime.of(2025, 11, 14, 10, 0);

        if(rm1.Add(start, end, "CS")){
            System.out.println("Room successfully booked.");
        } else {
            System.out.println("Room already book, please try a different room.");
        }
    }
}*/
