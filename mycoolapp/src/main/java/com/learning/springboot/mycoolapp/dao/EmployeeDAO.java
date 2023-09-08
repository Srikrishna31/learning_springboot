package com.learning.springboot.mycoolapp.dao;

import com.learning.springboot.mycoolapp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
