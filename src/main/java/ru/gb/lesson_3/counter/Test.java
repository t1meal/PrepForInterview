package ru.gb.lesson_3.counter;

public class Test {

    public static void main(String[] args) {
        SyncCounter counter = new SyncCounter();
        new Thread(counter::inc).start();
        new Thread(counter::dec).start();
        new Thread(counter::inc).start();
        new Thread(counter::dec).start();
    }
}
