package main.Business;


import main.Business.controller.User;

import java.util.TreeMap;

public class City {

    private final TreeMap<String, Hall> halls;
    private final TreeMap<String, User> users;

    String name;

    public City(String name) {
        halls = new TreeMap<>();
        users = new TreeMap<>();
        this.name = name;
    }

    public boolean containsHall(String name) {
        return halls.containsKey(name);
    }
    public Hall getHall(String name){
        if(!containsHall(name))
            throw new IllegalArgumentException("No hall named "+name+" in"+ this.name);
        else return halls.get(name);
    }
    public void addHall(String name, int sits) {
        if (containsHall(name))
            throw new IllegalArgumentException("Hall name in city already exists");
        halls.put(name, new Hall(sits, name));
    }

    @Override
    public boolean equals(Object object) {
        if (object.equals(this))
            return true;
        else if (object instanceof City city) {
            return city.name.equals(name);
        }
        return false;
    }
    public void addUser(String userName,String password){
        if(users.containsKey(userName))
            throw new IllegalArgumentException("Username already exists in system");
        else users.put(userName,new User(userName,password));
    }
    public boolean AttemptLogin(String userName,String password){
        if(users.containsKey(userName)) {
            User user=users.get(userName);
            return user.Login(userName,password);

        }
        throw new IllegalArgumentException("Incorrect username or password");
    }

}
