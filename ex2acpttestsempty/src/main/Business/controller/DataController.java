package main.Business.controller;

import main.Business.City;
import main.Business.Hall;

import java.util.TreeMap;

public class DataController {
    private final TreeMap<String,City> cities;


    public DataController(){
        cities=new TreeMap<>();
    }
    public void addCity(String name){
        if(cities.containsKey(name))
            throw new IllegalArgumentException("City already exists");
        cities.put(name,new City(name));
    }
    public void addHall(String city,String name,int sits){
        if(!cities.containsKey(city))
            throw new IllegalArgumentException("City not in system");
        cities.get(city).addHall(name,sits);
        }
    public void addUser(String city,String userName,String password){
        if(!cities.containsKey(city))
            throw new IllegalArgumentException("City not in system");
        cities.get(city).addUser(userName,password);
    }
    public void AttemptLogin(String city,String userName,String password){
        if(!cities.containsKey(city))
            throw new IllegalArgumentException("City not in system");
        if(!cities.get(city).AttemptLogin(userName,password))
            throw new IllegalArgumentException("Login failed, INTRUDER DETECTED: COMMENCING SYSTEM PURGE");

    }
    public Hall getHall(String city,String hallName){
        if(!cities.containsKey(city))
            throw new IllegalArgumentException("No city named "+city+" in system");
        return cities.get(city).getHall(hallName);
    }
}
