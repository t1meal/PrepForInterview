package ru.gb;

public class Lorry extends Car implements Movements {
    @Override
    public void move() {
        System.out.println("something");
    }
    @Override
    public void stop() {
        System.out.println("something");
    }
    @Override
    void open() {
        System.out.println("something");
    }

}

