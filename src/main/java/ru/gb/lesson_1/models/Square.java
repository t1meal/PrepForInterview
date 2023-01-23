package ru.gb.lesson_1.models;

import ru.gb.lesson_1.Figures;


public class Square extends Figures {

    public Square() {
        super();
    }
    @Override
    public void init() {
        System.out.println("I am a Square!");
    }
}

