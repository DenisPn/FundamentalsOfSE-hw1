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
    private final ArrayList<OrderInfo> waitingOrders;
    int ordersCount=1;

    public Show(ShowInfo showInfo,Hall hall){
        orders=new TreeMap<>();
        waitingOrders=new ArrayList<>();
        occupiedSits=new boolean[hall.getSeats()];
        for(int i=0;i<hall.getSeats();i++){
            occupiedSits[i]=false;
        }
        this.hall=hall;
        this.showInfo=showInfo;
    }
    public void reserveMemberChairs(int from, int to){
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
        if(order.memberId<1)
            throw new IllegalArgumentException("Invalid memeber id");
        if(order.chairsIds.length==0)
            throw new IllegalArgumentException("No chairs in order");
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
}
