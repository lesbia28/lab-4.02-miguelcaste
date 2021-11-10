package com.ironhack.lab4.miguelcaste.controller.interfaces;

import com.ironhack.lab4.miguelcaste.model.Employee;

import java.util.List;

public interface EmployeeController {
    List<Employee> getAll();
    Employee getById( Long id) ;
    List<Employee> getByStatus(String status);
    List<Employee> getByDepartment(String department);
}
