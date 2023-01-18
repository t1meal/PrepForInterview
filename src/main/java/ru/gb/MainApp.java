package ru.gb;


import ru.gb.models.Person;

import java.util.ArrayList;
import java.util.List;

public class MainApp
{
    public static void main( String[] args){

        // 1. Создание экземпляра класса со статическим методом иниализации и стическим вложенным классом.
        Person firstPerson = Person.builder()
                .firstName("Alex")
                .lastName("Lesly")
                .middleName("Git")
                .country("Russia")
                .address("Vladimir")
                .phone("88005555535")
                .age(30)
                .gender("Male")
                .build();

        // 1. Реализация билдера без статики.
//        Person anotherPerson = new Person().builder()
//                .firstName("Bob")
//                .lastName("Frouly")
//                .middleName("tinker")
//                .country("USA")
//                .address("Minnesota")
//                .phone("89005557575")
//                .age(40)
//                .gender("Male")
//                .build();

        System.out.println(firstPerson);
//        System.out.println(anotherPerson);

        // 2. Реализация полиморфизма. Можно было бы описать еще методы с одиновыми названиями, но принимающие разные аргументы, но это не интересно))
        Figures circle = new Circle();
        Figures square = new Square();
        Figures triangle = new Triangle();

        List<Figures> list = new ArrayList<>();
        list.add(circle);
        list.add(square);
        list.add(triangle);

        for (Figures f: list){
            f.init();
        }
    }
}
