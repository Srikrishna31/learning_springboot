package com.learning.springboot.mycoolapp.service;

import com.learning.springboot.mycoolapp.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Optional<List<Employee>> findAll();
}
