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

    @Override
    public Employee findById(int theId) {
        return entityManager.find(Employee.class, theId);
    }

    @Override
    public Employee save(Employee theEmployee) {
        // If the id is 0, then it inserts, otherwise it updates the existing employee.
        return entityManager.merge(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        var theEmployee = entityManager.find(Employee.class, theId);

        entityManager.remove(theEmployee);
    }
}
