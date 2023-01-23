package ru.gb.lesson_1;

public class BenzineEngine extends Engine {

    private String typeOfPetrol;

    @Override
    public void setTypeOfPetrol(String type) {
        this.typeOfPetrol = type;
    }

    public BenzineEngine(String type) {
        super(type);
    }

    public String getTypeOfPetrol() {
        return typeOfPetrol;
    }
}
