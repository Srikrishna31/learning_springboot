package com.learning.springboot.mycoolapp.dao;

import com.learning.springboot.mycoolapp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
