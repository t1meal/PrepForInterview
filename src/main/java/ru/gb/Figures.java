package ru.gb;

public class Figures {
    private final String type;

    public Figures() {
        this.type = "geometry";
    }

    public  void init(){
        System.out.println("Im figure!");
    }

    public String getType() {
        return type;
    }
}




