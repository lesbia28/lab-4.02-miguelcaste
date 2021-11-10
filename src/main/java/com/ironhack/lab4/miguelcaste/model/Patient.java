package com.ironhack.lab4.miguelcaste.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    @Column(name = "date_of_birth")
    private Date date;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Employee admitted_by;
}




