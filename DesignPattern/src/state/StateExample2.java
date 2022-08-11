package state;

enum HotelStateEnum {
    FREEMTIME_STATE,  //空闲状态
    BOOKED_STATE,    //已预订状态
    CHECKIN_STATE;   //入住状态
}

//1 此接口定义各个状态的统一操作接口
interface HotelState{
    void operate();
}

//2.1 实现各种状态类：空闲状态类
class FreeTimeState implements HotelState{
    private HotelStateEnum state;

    @Override
    public void operate() {
        System.out.println("房间为空，预定该房间");
        state = HotelStateEnum.BOOKED_STATE;
    }
}

//2.2 实现各种状态类：预定状态类
class BookedState implements HotelState{
    private HotelStateEnum state;

    @Override
    public void operate() {
        System.out.println("房间已预定，入住该房间");
        state = HotelStateEnum.CHECKIN_STATE;
    }
}

//2.3 实现各种状态类：入住状态类
class CheckinState implements HotelState{
    private HotelStateEnum state;

    @Override
    public void operate() {
        System.out.println("房间已入住，退房");
        state = HotelStateEnum.FREEMTIME_STATE;
    }
}

//定义一个酒店Context类
class HotelContext{
    private HotelState hotelState;

    public HotelState getHotelState() {
        return hotelState;
    }

    public void setHotelState(HotelState hotelState) {
        this.hotelState = hotelState;
    }

    public void doAction(){
        hotelState.operate();
    }
}


public class StateExample2 {
    public static void main(String[] args) {
        HotelContext hotelContext = new HotelContext();

        //空闲状态
        FreeTimeState freeTimeState = new FreeTimeState();
        hotelContext.setHotelState(freeTimeState);
        hotelContext.doAction();

        //预定状态
        BookedState bookedState = new BookedState();
        hotelContext.setHotelState(bookedState);
        hotelContext.doAction();

        //入住状态
        CheckinState checkinState = new CheckinState();
        hotelContext.setHotelState(checkinState);
        hotelContext.doAction();
    }
}
