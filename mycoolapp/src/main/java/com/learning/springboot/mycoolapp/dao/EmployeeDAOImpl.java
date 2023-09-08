package com.learning.springboot.mycoolapp.dao;

import com.learning.springboot.mycoolapp.entity.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        var theQuery = entityManager.createQuery("from Employee", Employee.class);
        return theQuery.getResultList();
    }
}
