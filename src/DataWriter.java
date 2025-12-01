import java.io.FileWriter;

class DataWriter extends Data(){


    public DataWriter(){
        super();
    }

    public void addModuleTimeSlot(String[] output;) {
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

    public void addRoom(String[] output;) {
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
}