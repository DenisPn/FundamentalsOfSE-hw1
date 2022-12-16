package main.Business;

import main.data.OrderInfo;
import main.data.ShowInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Show {
    public Hall hall;
    public ShowInfo showInfo;
    public boolean[] occupiedSits; //true=occupied/reserved
    public final TreeMap<Integer,OrderInfo> orders;
   // public final TreeMap<Integer,D> reservationsByName;
    private final ArrayList<OrderInfo> waitingOrders;
    int ordersCount=1;

    public Show(ShowInfo showInfo,Hall hall){
        if(showInfo.lastOrderDate>showInfo.showDate)
            throw new IllegalArgumentException("Show last order date set to after be after the show");
        if(showInfo.showDate<System.currentTimeMillis()  | showInfo.city.equals("") | showInfo.name.equals("") | showInfo.ticketCost<0)
            throw new IllegalArgumentException("Invalid show parameters");
        orders=new TreeMap<>();
        waitingOrders=new ArrayList<>();
     //   reservationsByName=new TreeMap<>();
        occupiedSits=new boolean[hall.getSeats()];
        for(int i=0;i<hall.getSeats();i++){
            occupiedSits[i]=false;
        }
        this.hall=hall;
        this.showInfo=showInfo;
    }
    public void reserveMemberChairs(int from, int to){
        if(to<=from || from<0)
            throw new IllegalArgumentException("Invalid to/from values");
        for(int i=from;i<to;i++){
            if(occupiedSits[i]) {
                throw new IllegalArgumentException("Chosen seats are already reserved");
            }
        }
        for(int i=from;i<to;i++){
            occupiedSits[i]=true;
        }
    }
    public int addOrder(OrderInfo order) {
        confirmFields(order);
       // if(order)
        for(int i=0;i<order.chairsIds.length;i++){
            if(occupiedSits[order.chairsIds[i]])
                return -1;
        }
        int id=order.showId+ordersCount;
        orders.put(id,order);
        if(showInfo.showTime==null)
            waitingOrders.add(order);
        return id;
    }
    public List<OrderInfo> getWaitingOrders(){
        return waitingOrders;
    }
    public void confirmFields(OrderInfo orderInfo){
        if(orderInfo.memberId<1)
            throw new IllegalArgumentException("Invalid memeber id");
        if(orderInfo.chairsIds.length==0)
            throw new IllegalArgumentException("No chairs in order");
        if(orderInfo.showId<1)
            throw new IllegalArgumentException("invalid showIDr");
        if(orderInfo.phone.equals(""))
            throw new IllegalArgumentException("Invalid phone number");
        if(orderInfo.name.equals(""))
            throw new IllegalArgumentException("Invalid name");
        if(showInfo.lastOrderDate<System.currentTimeMillis())
            throw new IllegalArgumentException("today is later then last order date");

    }
}
