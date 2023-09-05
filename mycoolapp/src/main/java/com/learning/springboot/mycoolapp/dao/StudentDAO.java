package com.learning.springboot.mycoolapp.dao;

import com.learning.springboot.mycoolapp.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDAO {
    void save(Student theStudent);

    Optional<Student> findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);
}
