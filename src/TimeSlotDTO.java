class TimeSlotDTO{
    public String moduleName, moduleDates, day, start, end, room, classType, lecturer;

    public TimeSlotDTO(String[] line){
        IO.println(line.length);
        this.moduleName = line[0];
        this.moduleDates = line[1];
        this.day = line[2];
        this.start = line[3];
        this.end = line[4];
        this.room = line[5];
        this.classType = line[6];
        this.lecturer = line[7];
    }

    @Override
    public String toString(){
        return moduleName + "," + moduleDates + "," + day + "," + start + "," 
            + end + "," + room + "," + classType + "," + lecturer;
    }
}