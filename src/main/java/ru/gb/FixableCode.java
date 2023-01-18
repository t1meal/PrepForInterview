package ru.gb;

public class FixableCode {
}

interface Moveable {
    void move();
}
interface Stopable {
    void stop();
}
abstract class Car {
    // 1. В поле содержится ссылка на экземпляр не существующего класса.
    public Engine engine;
    private String color;
    private String name;

    protected void start() {
        System.out.println("Car starting");
    }
    abstract void open();

    //  1. Гетер на экземпляр не существующего класса
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
//   Решение:
class Engine {
    private final String type;

    public String getType() {
        return type;
    }

    public Engine (String type){
        this.type = type;
    }
    public void startEngine(){
        System.out.println("Engine is starts!");
    }
}
//  описать недостающий класс.


class LightWeightCar extends Car implements Moveable {
    @Override
    void open() {
        System.out.println("Car is open");
    }
    @Override
    public void move() {
        System.out.println("Car is moving");
    }
}

//     2. множественно наследование запрещено, не реализован метод open от класса Car.

//class Lorry extends Car, Moveable, Stopable {
//    public void move(){
//        System.out.println("Car is moving");
//    }
//    public void stop(){
//        System.out.println("Car is stop");
//    }

//      Решение:
class Lorry extends Car implements Moveable, Stopable {

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
    //  наследуемся от Car, реализуем оба интерфейса.
}
