package state;

class Hotel{
    public static final int FREEMTIME_STATE = 0;  //空闲状态
    public static final int BOOKED_STATE = 1;     //已预订状态
    public static final int CHECKIN_STATE = 2;    //入住状态

    private int state;

    public void setState(int state) {
        this.state = state;
    }

    public void Operate(){
        if (state == FREEMTIME_STATE){
            System.out.println("房间为空，预定该房间");
            state = BOOKED_STATE;
        }else if (state == BOOKED_STATE){
            System.out.println("房间已预定，入住该房间");
            state = CHECKIN_STATE;
        }else if (state == CHECKIN_STATE){
            System.out.println("房间已入住，退房");
            state = FREEMTIME_STATE;
        }
    }
}

public class StateExample1 {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        hotel.setState(Hotel.FREEMTIME_STATE);
        hotel.Operate();

        hotel.setState(Hotel.BOOKED_STATE);
        hotel.Operate();

        hotel.setState(Hotel.CHECKIN_STATE);
        hotel.Operate();
    }
}
