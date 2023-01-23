package ru.gb.lesson_1;

public abstract class Engine {

    private final String type;

    public abstract void setTypeOfPetrol(String type);

    public void startEngine() {
        System.out.println("Engine is starts!");
    }

    public void stopEngine() {
        System.out.println("Engine is starts!");
    }

    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
