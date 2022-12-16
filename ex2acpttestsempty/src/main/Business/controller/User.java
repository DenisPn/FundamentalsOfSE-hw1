package main.Business.controller;

import main.data.OrderInfo;

import java.util.Arrays;

public class User {
    private String userName;
    private String password;

    public User(String userName,String password){
        if(userName==null | password==null)
            throw new IllegalArgumentException("Empty username or password");
        this.userName=userName;
        this.password=password;
    }
    public boolean Login(String userName,String password){
        return userName.equals(this.userName) & password.equals(this.password);
    }
    @Override
    public boolean equals(Object object){
        if(object.equals(this))
            return true;
        else if(object instanceof User info){
            return info.userName.equals(userName); //we allow multiple users to have the same password
        }
        return false;
    }

}
