package ru.gb.lesson_2;

public class Test {

    public static void main(String[] args) {

        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.showAll();

        list.removeFirst();
        list.showAll();

        list.removeLast();
        list.showAll();

        System.out.println(list.contains(6));

    }
}
