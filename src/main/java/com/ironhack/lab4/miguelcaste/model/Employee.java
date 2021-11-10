package com.ironhack.lab4.miguelcaste.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ironhack.lab4.miguelcaste.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String department;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(mappedBy = "admitted_by")
    @JsonBackReference
    @Getter
    @Setter
    private List<Patient> patientList;
}
