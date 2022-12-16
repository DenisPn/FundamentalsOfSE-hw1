package main.Business;


public class Hall {
    private final int totalSeats;
    private final String name;

    public Hall(int totalSeats,String name){
        this.totalSeats=totalSeats;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public int getSeats() {
        return totalSeats;
    }
}
