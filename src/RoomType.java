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
}