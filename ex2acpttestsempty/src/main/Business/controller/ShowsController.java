package main.Business.controller;

import main.Business.Hall;
import main.Business.Show;
import main.data.OrderInfo;
import main.data.ShowInfo;


import java.time.LocalTime;
import java.util.*;

public class ShowsController {
    int idTracker=1;
    private final TreeMap<Integer, Show> shows;
    private final HashMap<Long,TreeMap<LocalTime,Show>> showTimes;
    public ShowsController(){
        shows=new TreeMap<>();
        showTimes=new HashMap<>();
    }
    public int addShow(ShowInfo showInfo, Hall hall){
        if(showInfo.hastime && showTimes.containsKey(showInfo.showDate) && showTimes.get(showInfo.showDate).containsKey(showInfo.showTime))
            if((showTimes.get(showInfo.showDate).get(showInfo.showTime)).showInfo.equals(showInfo))
                throw new IllegalArgumentException("Space in hall at specified time already occupied");
        if((!showInfo.hastime & showInfo.showTime!=null) || (showInfo.hastime & showInfo.showTime==null))
            return -1;
        Show show=new Show(showInfo,hall);
        int id=idTracker;
        shows.put(id,show);
        if(!showTimes.containsKey(showInfo.showDate))
            showTimes.put(showInfo.showDate,new TreeMap<>());
        if(showInfo.hastime)
            showTimes.get(showInfo.showDate).put(showInfo.showTime,show);
        idTracker+=1+hall.getSeats(); //for show in hall with x seats for idtracker y, show id is y and each order id in it is y+(number of orders for show)
        return id;
    }

    public void reserveMemberChairs(int showID, int from, int to) {
        if(!shows.containsKey(showID))
            throw new IllegalArgumentException("no show with id: "+showID);
        shows.get(showID).reserveMemberChairs(from,to);
    }

    public int newOrder(OrderInfo order) {
        if(!shows.containsKey(order.showId))
            throw new IllegalArgumentException("No show with id: "+order.showId);
        else return shows.get(order.showId).addOrder(order);
    }

    public List<OrderInfo> getWaitings(int id) {
        if(!shows.containsKey(id))
            return new ArrayList<>();
        else return shows.get(id).getWaitingOrders();
    }
}
