package com.ironhack.lab4.miguelcaste.repository;

import com.ironhack.lab4.miguelcaste.enums.Status;
import com.ironhack.lab4.miguelcaste.model.Employee;
import com.ironhack.lab4.miguelcaste.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long>  {
    List<Patient> findByDateBetween(Date initialDate, Date finalDate);

}
