import java.util.LinkedList;

/**
 * This also communicates with view to create a Timetable for Room and stores all relevent information about room
 */
class Rooms{
    private String name;
    private LinkedList<Booking> bookings;

    public Rooms(String name){
        this.name = name;
        this.bookings = new LinkedList<>();
    }

    public boolean isAvailabile(Booking booking){
        for(Booking x : bookings){
            if(x.doubleBooked(booking)){
                return false;
            }
        }
        return true;
    }

    public boolean Add(Booking booking){ // pass booking
        if(isAvailabile(booking)){
            bookings.add(booking);
            return true;
        }
        return false;
    }
    public void show(){
        System.out.println(name + "bookings");
        System.out.println(": " + bookings.toString());
    }
}