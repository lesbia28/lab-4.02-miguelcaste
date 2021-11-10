package com.ironhack.lab4.miguelcaste.controller.impl;

import com.ironhack.lab4.miguelcaste.controller.interfaces.PatientController;
import com.ironhack.lab4.miguelcaste.enums.Status;
import com.ironhack.lab4.miguelcaste.model.Employee;
import com.ironhack.lab4.miguelcaste.model.Patient;
import com.ironhack.lab4.miguelcaste.repository.EmployeeRepository;
import com.ironhack.lab4.miguelcaste.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@RestController
public class PatientControllerImpl implements PatientController {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/patient")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @GetMapping("/patient/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getById(@PathVariable Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Patient with id " + id + " not found"));
        return patient;
    }

    @GetMapping("/patient/between-date")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getBetweenDate(@RequestParam String initialDate,@RequestParam String finalDate) {
        return (patientRepository.findByDateBetween(Date.valueOf(initialDate), Date.valueOf(finalDate)));
    }


    @GetMapping("/patient/employee-status-off")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getByEmployeeStatusOff() {
        List<Employee> employeeList=employeeRepository.findByStatus(Status.OFF);
        if(employeeList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "There is not Patient with status OFF");
        }
        else{
            List<Patient> patientList=new ArrayList<>();
            for (Employee e: employeeList) {
                patientList.addAll(e.getPatientList());
            }
            return(patientList);
        }
    }

    @GetMapping("/patient/employee-department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getByEmployeeDepartment(@PathVariable String department) {
        List<Employee> employeeList=employeeRepository.findByDepartment(department);
        if(employeeList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    " Patient with the department " +department+ " is not found");
        }
        else{
            List<Patient> patientList=new ArrayList<>();
            for (Employee e: employeeList) {
                patientList.addAll(e.getPatientList());
            }
            return(patientList);
        }
    }
}

