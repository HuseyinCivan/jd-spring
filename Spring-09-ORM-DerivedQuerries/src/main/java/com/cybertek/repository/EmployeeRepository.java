package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //display all employees with email address is '';
    List<Employee> findByEmail(String email);

    //display all employees with first name '' and last name '' also show all employees with an email address is ''
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    //display all employees that first name is not ''
    List<Employee> findByFirstNameIsNot(String firstName);

    //display all employees where last name starts with ''
    List<Employee> findByLastNameStartsWith(String pattern);

    //display all employees with salaries higher than ''
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //display all employees with salaries less than and equal ''
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    //display all employees that has been hires between '' and ''
    List<Employee> findByHireDateBetween(LocalDate date1 , LocalDate date2);

    //display all employees where salaries greater and equal to '' in order
    List<Employee> findBySalaryIsGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //display top unique 3 employees that is making less than ''
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);


    //display all employees  that do not have email address
    List<Employee> findByEmailIsNull();



}
