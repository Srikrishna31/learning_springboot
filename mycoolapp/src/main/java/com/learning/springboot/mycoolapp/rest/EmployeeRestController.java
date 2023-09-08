package com.learning.springboot.mycoolapp.rest;

import com.learning.springboot.mycoolapp.dao.EmployeeDAO;
import com.learning.springboot.mycoolapp.entity.Employee;
import com.learning.springboot.mycoolapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/employees/{employeeId}")
    Employee getEmployee(@PathVariable int employeeId) {
        var theEmployee = employeeService.findById(employeeId);

        if (theEmployee.isEmpty()) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee.get();
    }

    @PostMapping("/employees")
    Employee addEmployee(@RequestBody Employee theEmployee) {
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        theEmployee.setId(0);

        return employeeService.save(theEmployee);
    }
}
