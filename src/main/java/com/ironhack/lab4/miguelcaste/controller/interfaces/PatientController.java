package com.ironhack.lab4.miguelcaste.controller.interfaces;


import com.ironhack.lab4.miguelcaste.model.Patient;



import java.util.List;

public interface PatientController {
    List<Patient> getAll();
    Patient getById(Long id);
    List<Patient> getBetweenDate(String initialDate, String finalDate);
    List<Patient> getByEmployeeStatusOff();
    List<Patient> getByEmployeeDepartment(String department);
}
