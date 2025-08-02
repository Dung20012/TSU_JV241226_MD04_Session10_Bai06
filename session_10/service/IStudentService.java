package com.data.session_10.service;

import com.data.session_10.model.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void delete(Long id);
    void save(Student student);
    void update(Student student);
    Student findById(Long id);
}
