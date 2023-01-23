package ru.gb.lesson_1.models;

import ru.gb.lesson_1.Figures;

    public class Circle extends Figures {
        public Circle() {
            super();
        }
        @Override
        public void init() {
            System.out.println("I am a Circle!");
        }

}
