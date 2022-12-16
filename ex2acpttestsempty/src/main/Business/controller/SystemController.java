package main.Business.controller;

import main.data.OrderInfo;
import main.data.ShowInfo;

import java.util.ArrayList;
import java.util.List;

public class SystemController {

    DataController dataController;
    ShowsController showsController;
    public SystemController(){
        dataController=new DataController();
        showsController=new ShowsController();
    }
    public void addCity(String city){
        try {
            dataController.addCity(city);
        }
        catch (Exception ignored){
            // no error handling
        }

    }

    public void addHall(String city, String hall, int sits){
        try {
            dataController.addHall(city,hall,sits);
        }
        catch (Exception ignored){
            // no error handling
        }

    }

    public void addAdmin(String city, String user, String pass){
        try{
            dataController.addUser(city, user, pass);
        }
        catch (Exception ignored){
            // no error handling
        }

    }

    public int addNewShow(String user, String pass, ShowInfo showInfo){

        try {
            dataController.AttemptLogin(showInfo.city,user,pass);
                //throw new IllegalArgumentException("Incorrect username or password");
            return showsController.addShow(showInfo, dataController.getHall(showInfo.city, showInfo.hall));
        }
        catch (Exception e){
            return -1;
        }

    }

    public void reserveMemberChairs(int showID, int from, int to){
        try {
            showsController.reserveMemberChairs(showID, from, to);
        }
        catch (Exception ignored){
            // no error handling
        }
    }

    public int newOrder(OrderInfo order){
        try{
            return showsController.newOrder(order);
        }
        catch (Exception ignored){
            return -1;
        }

    }

    public List<OrderInfo> getWaitings(int id){
        try{
            return showsController.getWaitings(id);
        }
        catch (Exception ignored){
            return new ArrayList<>();
        }

    }

}
