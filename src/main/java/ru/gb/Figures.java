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

class Circle extends Figures {
    public Circle() {
        super();
    }
    @Override
    public void init() {
        System.out.println("I am a Circle!");
    }
}
class Square  extends Figures {

    public Square() {
        super();
    }
    @Override
    public void init() {
        System.out.println("I am a Square!");
    }
}

class Triangle extends Figures {
    @Override
    public void init() {
        System.out.println("I am a Triangle!");
    }
}
