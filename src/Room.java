import java.util.ArrayList;

/**
 * <p> This also communicates with view to create a Timetable for Room and stores all relevent information about room </p>
 */
class Rooms{
    private String name;
    int capacity;
    private ArrayList<Booking> bookings;

    public Rooms(String name){
        this.name = name;
        this.bookings = new ArrayList<>();
    }

    //public boolean isAvailabile(Booking booking){ // requires new implementation
    //    for(Booking x : bookings){
    //        if(x.doubleBooked(booking)){
    //            return false;
    //        }
    //    }
    //    return true;
    //}

    //public boolean Add(Booking booking){ // requires new implementation
    //    if(isAvailabile(booking)){
    //        bookings.add(booking);
    //        return true;
    //    }
    //    return false;
    //}
}