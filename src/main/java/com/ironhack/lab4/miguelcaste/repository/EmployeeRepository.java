package com.ironhack.lab4.miguelcaste.repository;

import com.ironhack.lab4.miguelcaste.enums.Status;
import com.ironhack.lab4.miguelcaste.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee,Long> {

    List<Employee> findByStatus(Status status) ;
    List<Employee> findByDepartment(String department) ;

}
