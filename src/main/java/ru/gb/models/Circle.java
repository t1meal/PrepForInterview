package ru.gb.models;

import ru.gb.Figures;

    public class Circle extends Figures {
        public Circle() {
            super();
        }
        @Override
        public void init() {
            System.out.println("I am a Circle!");
        }

}
