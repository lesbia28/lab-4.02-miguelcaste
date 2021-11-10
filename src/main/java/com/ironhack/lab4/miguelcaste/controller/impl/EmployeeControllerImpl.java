package com.ironhack.lab4.miguelcaste.controller.impl;

import com.ironhack.lab4.miguelcaste.controller.interfaces.EmployeeController;
import com.ironhack.lab4.miguelcaste.enums.Status;
import com.ironhack.lab4.miguelcaste.model.Employee;
import com.ironhack.lab4.miguelcaste.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;


@RestController
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }


    @GetMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getById(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Employee with id " + id + " not found"));
        return employee;
    }

    @GetMapping("/employee-by-status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getByStatus(@PathVariable String status){
        return(employeeRepository.findByStatus(Status.valueOf(status)));
    }

    @GetMapping("/employee-by-department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getByDepartment(@PathVariable String department) {
        return(employeeRepository.findByDepartment(department));
    }
}
