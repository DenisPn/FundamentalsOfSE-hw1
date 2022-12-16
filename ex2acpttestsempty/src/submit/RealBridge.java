package submit;

import main.Business.controller.SystemController;
import main.bridge.Bridge;
import main.data.OrderInfo;
import main.data.ShowInfo;

import java.util.List;

public class RealBridge implements Bridge {
    SystemController systemController;
    public RealBridge(){
        this.systemController=new SystemController();
    }
    @Override
    public void addCity(String city) {
        systemController.addCity(city);
    }

    @Override
    public void addHall(String city, String hall, int sits) {
        systemController.addHall(city,hall,sits);
    }

    @Override
    public void addAdmin(String city, String user, String pass) {
        systemController.addAdmin(city, user, pass);
    }

    @Override
    public int addNewShow(String user, String pass, ShowInfo showInfo) {
        return systemController.addNewShow(user, pass, showInfo);
    }

    @Override
    public void reserveMemberChairs(int showID, int from, int to) {
        systemController.reserveMemberChairs(showID, from, to);
    }

    @Override
    public int newOrder(OrderInfo order) {
        return systemController.newOrder(order);
    }

    @Override
    public List<OrderInfo> getWaitings(int id) {
        return systemController.getWaitings(id);
    }
}
