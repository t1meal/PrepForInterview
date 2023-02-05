package ru.gb.lesson_5;


import ru.gb.lesson_5.dao.StudentDao;
import ru.gb.lesson_5.entities.Student;

//        1. Создать базу данных Student с полями id, name, mark. +
//        2. Создать сущность Student и добавить в нее аннотации. Поле id должно заполняться автоматически. +
//        3. Создать конфигурационный файл hibernate.cfg.xml, в котором указать свойства для подключения к БД и список классов с аннотациями Entity. +
//        4. Создать класс со статическим методом, который возвращает объект SessionFactory. +
//        5. Создать DAO-слой с операциями добавления, удаления, изменения сущности, выборки записи по ID и всех записей. +
//        6. Добавить 1000 записей в таблицу Student. +
//        7. Проверить работоспособность приложения, выполнить методы по удалению, изменению, добавлению записей, а также выборки одной и всех записей.

public class App {

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();

        for (int i = 0; i < 1000; i++){
            studentDao.saveOrUpdate(new Student("Student" + i, i));
        }

        Student alex = new Student("Alex", 5);
        studentDao.saveOrUpdate(alex);

        System.out.println(studentDao.findById(50L));

        studentDao.delete(alex);

        System.out.println(studentDao.findAll());

    }
}
