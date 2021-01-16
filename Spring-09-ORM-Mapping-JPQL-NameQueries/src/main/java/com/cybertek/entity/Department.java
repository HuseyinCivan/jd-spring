package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@ToString
@NamedQuery(name = "Department.findOzzydepartment",query = "Select d from Department d where d.division=?1")
@NamedNativeQuery(name = "Department.countAllDepartments",query = "SELECT * from departments",resultClass = Department.class)
public class Department {

    @Id
    private String department;

    private String division;
}
