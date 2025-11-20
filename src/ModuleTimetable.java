//import java.time.DayOfWeek; we alrea have an enum for it
//import java.util.*; // legendary))
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Collections;
/**
 * <p>This gathers the nessecary information to create a Modulue it also communicates with the view class </p>
 */
// Module calss was just a copy of Cians TimeSlot, redundant

class ModuleTimetable{
    private String name;
    private LinkedList<TimeSlot> moduleTimes;

    public ModuleTimetable(String name){
        this.name = name;
        moduleTimes = new LinkedList<>();
        sortSlots();
    }

    public void add(TimeSlot timeSlot){
        moduleTimes.add(timeSlot);
    }

    public String getName(){
        return this.name;
    }

    private void sortSlots(){
        for(int i = 0; i < moduleTimes.size(); i++){
            for(int j = 0; j < moduleTimes.size() - 1 - i; j++){
                if(moduleTimes.get(j + 1).getStart() < moduleTimes.get(j).getStart()){
                    Collections.swap(moduleTimes, j + 1, j);
                }
            }
        } // they are sorted by time

        int temp = -1; // itterator to store the last element with same start time
        for(int i = 0; i < moduleTimes.size(); i++){
            for(int j = i + 1; j < moduleTimes.size() ; j++){
                if(moduleTimes.get(i).getStart() != moduleTimes.get(j).getStart()){
                    temp = j - 1;
                }
            }
            if(temp != i){
                for(int k = i; k <= temp; k++){
                    for(int j = i; j <= temp - 1 - k + i; j++){ // temp - 1 - k + i bubbles sort right boundary offset by i
                        if(moduleTimes.get(j + 1).getDay().toInt() < moduleTimes.get(j).getDay().toInt()){
                            Collections.swap(moduleTimes, j + 1, j);
                        }
                    }
                }
            } // sorted by start time and day
        }
    }
}
