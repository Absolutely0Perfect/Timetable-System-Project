import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;


 class Bookings {
private LocalDateTime start;
private LocalDateTime end;
private String description;

public Bookings(LocalDateTime start, LocalDateTime end, String description){
    this.start = start;
    this.end = end;
    this.description = description;
}

public boolean doubleBooked(LocalDateTime start, LocalDateTime end){
    return start.isBefore(end) && end.isAfter(start);
}
@Override
    public String toString(){
    return description + "starts at" + start + "ends at" + end;
}
static class Rooms{
   private String name;
   private List<Bookings> booking;

   public Rooms(String name){
       this.name = name;
       this.booking = new ArrayList<>();

   }

   public boolean Availability(LocalDateTime start, LocalDateTime end, String description){
       for(Bookings book : booking){
           if(book.doubleBooked(start, end)){
               return false;
           }
       }
    return true;
   }

   public boolean Add(LocalDateTime start, LocalDateTime end, String description){
       if(Availability(start, end, description)){
           booking.add(new Bookings(start,end,description));
           return true;
       }
       return false;
   }

   public void show(){
       System.out.println(name + "bookings");
       System.out.println(": " + booking);
   }
  }
}

class RoomTimetable{
     public static void main(String[] args){
         Bookings.Rooms rm1 = new Bookings.Rooms("csg");

         LocalDateTime start = LocalDateTime.of(2025, 11, 14, 9, 0);
         LocalDateTime end = LocalDateTime.of(2025, 11, 14, 10, 0);

         if(rm1.Add(start, end, "CS")){
             System.out.println("Room successfully booked.");
         } else {
             System.out.println("Room already book, please try a different room.");
         }
     }
}


