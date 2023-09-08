package com.learning.springboot.mycoolapp.rest;

import com.learning.springboot.mycoolapp.dao.EmployeeDAO;
import com.learning.springboot.mycoolapp.entity.Employee;
import com.learning.springboot.mycoolapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public Optional<List<Employee>> findAll() {
        return employeeService.findAll();
    }
}
