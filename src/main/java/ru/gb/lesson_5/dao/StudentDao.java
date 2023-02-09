package ru.gb.lesson_5.dao;



import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.gb.lesson_5.entities.Student;
import ru.gb.lesson_5.utils.Factory;

import javax.persistence.NoResultException;
import java.util.List;

@Getter
@Setter
public class StudentDao {

    private SessionFactory sessionFactory;

    public StudentDao() {
        this.sessionFactory = Factory.getSessionFactory();
    }

    public void saveOrUpdate(Student entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
        }
    }

    public Student findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Student student = session.createQuery(String.format("SELECT s FROM Student s WHERE s.id = %d", id), Student.class).getSingleResult();
            session.getTransaction().commit();
            return student;
        } catch (NoResultException e) {
            System.out.println("Объект с id " + id + " не найден!");
            return null;
        }
    }

    public void delete(Student entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Student student = session.createQuery(String.format("SELECT s FROM Student s WHERE s.name = %s", entity.getName()), Student.class).getSingleResult();
            session.delete(student);
            session.getTransaction().commit();
        } catch (NoResultException e) {
            System.out.println("Не удалось выполнить удаление сущности " + entity.toString());
        }
    }

    public List<Student> findAll() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<Student> result = session.createQuery(("from Student"), Student.class).getResultList();
            session.getTransaction().commit();
            return result;
        } catch (NoResultException e) {
            System.out.println("В базе данных отсутсвуют данные!");
            return null;
        }
    }

    public void deleteAll() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Student> students = findAll();
            for (Student s : students) {
                session.delete(s);
            }
        }

    }


}