package com.cybertek.entity;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "studentFirstName")
    private String first_name;
    @Column(name = "studentLasttName")
    private String last_name;
    @Column(name = "studentEmailAddress")
    private String email;
}
