package ru.gb;


import ru.gb.models.Person;

public class MainApp
{
    public static void main( String[] args){

        // 1. Создание экземпляра класса со статическим методом иниализации и стическим воженным классом.
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

        // 2. Реализация билдера без статики.
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
    }
}
