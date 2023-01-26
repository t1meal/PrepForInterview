package ru.gb.lesson_2;


public class Test {

    public static void main(String[] args) {

//        CustomLinkedList<Integer> list = new CustomLinkedList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        list.add(7);
//        list.add(8);
//        list.showAll();
//
//        list.removeFirst();
//        list.showAll();
//
//        list.removeLast();
//        list.showAll();
//
//        System.out.println(list.contains(6));

        CustomArrayList<Integer> arrayList = new CustomArrayList<>(2);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.showAll();

        arrayList.remove(2);
        arrayList.showAll();

        arrayList.remove(Integer.valueOf(4));
        arrayList.showAll();

        System.out.println(arrayList.contains(2));
        System.out.println(arrayList.contains(4));


    }
}
