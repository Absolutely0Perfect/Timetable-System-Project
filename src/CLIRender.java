import java.util.List;
import java.util.ArrayList;
/**
*  <p>This class is the CLI used to display any inputs the user needs to input.
 * Inherited from the abstract View Class.</p>
*/
class CLIRender extends ViewRender {
    public final int WIDTH = 25;

    public CLIRender() {}
    /**
     * <p>This method outputs a blank Timeslot and then inserts the nessescary data <p>
     */
    @Override
    public void displayTimetable(ModuleTimetable module) {
        List<TimeSlot> slots = module.getTimeSlots();
        String[] buffer = {"", "", "", "", ""};

        int currentDay = -1; // this is current PRINTING day e.g. the place where we stopped in the row printing
        boolean theRowPrinted = false;
        int previousTime = 0;
        int previousDay = 5; // this is the day last processed timeslot was in
        int time;
        int day;

        printEmptyRow();

        for (TimeSlot slot : slots) {
            time = slot.getStart() - 9; // offset so that 0 equals 9 am
            day = slot.getDay().toInt() - 1;

            for (int j = previousDay + 1; j <= 5 && (j < day || previousTime < time); j++) {// this part is to finish started rows
                appendEmptySlotToBuffer(buffer);

                if (j == 5) {
                    printBuffer(buffer);
                    theRowPrinted = false;
                    currentDay = -1;
                } else {
                    currentDay = j + 1;
                }
            }

            for (int j = previousTime + 1; j <= time - 1; j++) { // skip through rows without any info
                printEmptyRow();
            }

            if (!theRowPrinted) { // checks if we are in the middle of printing a row
                printRowBreak();
                theRowPrinted = true;
            }

            for (int j = Math.max(0, currentDay); j < day; j++) {// fills the row with info with empty slots in
                appendEmptySlotToBuffer(buffer);
            }

            appendSlotToBuffer(buffer, slot); // adds info to the row
            currentDay = day + 1;
            if (day == 5) {
                printBuffer(buffer);
                theRowPrinted = false;
                currentDay = -1;
            }

            previousTime = time;
            previousDay = day;
        } 
        // from here we just fill the rest of the timetable with empty slots 
        if(previousDay != 5){
            for(int j = previousDay + 1; j <= 5; j++){
                appendEmptySlotToBuffer(buffer);
            }
            printBuffer(buffer);
        }
        for(int j = previousTime + 1; j <= 8; j++){
            printEmptyRow();
        }
        printRowBreak();
    } // end of display timetable
    /**
     * <p>Method prints a break in the row <p>
     */
    private void printRowBreak(){
        for(int i = 1; i <= (WIDTH + 1) * 6; i++){
            IO.print("-");
        }
        IO.println("-");
    }
    /**
     * <p>Method prints and empty row <p>
     */
    private void printEmptyRow(){
        printRowBreak();
        for(int i = 1; i <= (WIDTH + 1) * 6; i++){
            if(i % (WIDTH + 1) == 1){
                IO.print("|");
            }
            else{
                IO.print(" ");
            }
        }
        IO.println("|");
    }
    /**
     * <p>Method buffer prints new line <p>
     */
    private void printBuffer(String[] buffer){
        for(int i = 0; i < buffer.length; i++){
            buffer[i] += "|";
            IO.println(buffer[i]);
            buffer[i] = "";
        }
    }
    /**
     * <p>Method buffer prints and empty row if slot is empty <p>
     */
    private void appendEmptySlotToBuffer(String[] buffer){
        for(int i = 0; i < buffer.length; i++){
            for(int j = 1; j <= (WIDTH + 1); j++){
                if(j % (WIDTH + 1) == 1){
                    buffer[i] += "|";
                }
                else{
                    buffer[i] += " ";
                }
            }
        }
    }

    void appendSlotToBuffer(String[] buffer, TimeSlot timeSlot){
        String startEnd = (timeSlot.getStart() < 10) ? " " + timeSlot.getStart() + "-" + timeSlot.getEnd() :
            timeSlot.getStart() + "-" + timeSlot.getEnd();
        buffer[0] += insertString(startEnd);
        buffer[1] += insertString(timeSlot.getModuleName() + "-" + timeSlot.getClassType().name());
        buffer[2] += insertString(timeSlot.getLecturer());
        buffer[3] += insertString(timeSlot.getRoom());
        buffer[4] += insertString("Wks:" + timeSlot.getModuleDates());
    }
    /**
     * <p>Method insert sting is a formatiing method <p>
     */
    private String insertString(String inserted){
        StringBuilder constructedString = new StringBuilder("|");
        for(int i = 0; i < (WIDTH - inserted.length()) / 2; i++){
            constructedString.append(" ");
        }
        constructedString.append(inserted);
        for(int i = 0; i < (WIDTH - inserted.length()) / 2; i++){
            constructedString.append(" ");
        }
        if((WIDTH - inserted.length()) % 2 == 1){
            constructedString.append(" ");
        }
        return constructedString.toString();
    }
}
