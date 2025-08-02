package com.data.session_10.repository;

import com.data.session_10.model.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class StudentRepositoryImpl implements IStudentRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Student", Student.class).list();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        if (student != null && !student.getIssStudying()) {
            session.delete(student);
        }
    }

    @Override
    public void save(Student student) {
        sessionFactory.getCurrentSession().save(student);
    }

    @Override
    public void update(Student student) {
        sessionFactory.getCurrentSession().update(student);
    }

    @Override
    public Student findById(Long id) {
        return sessionFactory.getCurrentSession().get(Student.class, id);
    }
}
