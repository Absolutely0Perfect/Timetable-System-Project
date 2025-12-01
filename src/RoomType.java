public enum RoomType{
    LEC, LAB;

    public static RoomType toRoomType(int i){
        switch(i){
        case 0:
            return LEC;
        case 1:
            return LAB;
        default:
            return null;
        }
    }

    public int toInt(){
        switch(this){
        case LEC:
            return 0;
        case LAB:
            return 1;
        }
        return -1;
    }
}