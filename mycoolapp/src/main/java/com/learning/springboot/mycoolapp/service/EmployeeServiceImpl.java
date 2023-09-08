package com.learning.springboot.mycoolapp.service;

import com.learning.springboot.mycoolapp.dao.EmployeeDAO;
import com.learning.springboot.mycoolapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Optional<List<Employee>> findAll() {
        return Optional.ofNullable(employeeDAO.findAll());
    }
}
