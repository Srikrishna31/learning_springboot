package com.learning.springboot.mycoolapp.service;

import com.learning.springboot.mycoolapp.dao.EmployeeDAO;
import com.learning.springboot.mycoolapp.entity.Employee;
import jakarta.transaction.Transactional;
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

    @Override
    public Optional<Employee> findById(int theId) {
        return Optional.ofNullable(employeeDAO.findById(theId));
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}
