package ru.gb.lesson_5.entities;



import lombok.*;
import javax.persistence.*;


@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int mark;

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }
}
