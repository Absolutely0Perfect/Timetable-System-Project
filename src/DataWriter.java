import java.io.FileWriter;
import java.io.File;
import java.nio.file.Files;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
/**
 * <p>This class gathers data and add its to each seaprate Timeslot type <p>
 */
class DataWriter extends Data{
    public DataWriter(){
        super();
    }
    /**
     * <p>This method gahters data from module and prints it to timeslot  <p>
     */
    public void editTimeSlot(TimeSlotDTO[] changing) {
        try {
            List<String> modules = readAllLines(this.modulesPath);

            for (int i = 0; i < modules.size(); i++) {
                if (modules.get(i).equals(changing[0].toString())) {
                    modules.set(i, changing[1].toString());
                }
            }

            Files.write(this.modulesPath, modules);
        } catch (IOException e) {
            IO.println("An error has occurred: " + e.getMessage());
            e.printStackTrace(); // Add stack trace for debugging
        }
    }

    public void addModuleTimeSlot(String[] output) {
        int i = 1;

        try (FileWriter modules = new FileWriter(this.modulesData)) {
            while (true) {
                if (Objects.equals(output[0], "0")) {
                    break;
                }

                StringBuilder line = new StringBuilder(output[0]);
                for (int j = 1; j < output.length; j++) {
                    line.append(",").append(output[j]);
                }
                line.append("\n");
                modules.append(line);
                i++;
            }
        } catch (IOException e) {
            IO.println("An error occurred.");
        }
    }
    /**
     * <p>This method gather course data and prints data from course timetable <p>
     */
    public void addCourse(String[] output) {
        int i = 1;

        try (FileWriter courses = new FileWriter(this.coursesData)) {
            while (true) {
                if (Objects.equals(output[0], "0")) {
                    break;
                }

                StringBuilder line = new StringBuilder(output[0]);
                for (int j = 1; j < output.length; j++) {
                    line.append(",").append(output[j]);
                }
                line.append("\n");
                courses.append(line);
                i++;
            }
        } catch (IOException e) {
            IO.println("An error occurred.");
        }
    }

    public void editStudentTimetable() {
        //to be implemented
    }
    /**
     * <p>This method gathers data from room and prints it to room timetable  <p>
     */
    public void addRoom(String[] output) {
        int i = 1;

        try (FileWriter rooms = new FileWriter(this.roomData)) {
            while (true) {
                if (Objects.equals(output[0], "0")) {
                    break;
                }

                StringBuilder line = new StringBuilder(output[0]);
                for (int j = 1; j < output.length; j++) {
                    line.append(",").append(output[j]);
                }

                line.append("\n");
                rooms.append(line);
                i++;
            }
        } catch (IOException e) {
            IO.println("An error occurred.");
        }
    }

    private List<String> readAllLines(Path filePath) throws IOException {
        if (!Files.exists(filePath)) {
            throw new IOException("File does not exist: " + filePath);
        }
        return Files.readAllLines(filePath);
    }
}