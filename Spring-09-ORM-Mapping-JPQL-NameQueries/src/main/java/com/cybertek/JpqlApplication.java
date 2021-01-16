package com.cybertek;

import com.cybertek.repository.DepartmentRepository;
import com.cybertek.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JpqlApplication {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;


    public static void main(String[] args) {
        SpringApplication.run(JpqlApplication.class, args);
    }


    @PostConstruct
    public void testEmployee() {
        System.out.println(employeeRepository.getEmployeeDetail());
        System.out.println(employeeRepository.getEmployeeSalary());

        System.out.println(employeeRepository.getEmployeeByEmail("dtrail8@tamu.edu").get());

        employeeRepository.updateEmployeeJPQL(1);

        employeeRepository.updateEmployeeNativeQuery(2);

        System.out.println(employeeRepository.retrieveEmployeesSalaryGreaterThan(100000));

        System.out.println(departmentRepository.findOzzydepartment("Kids"));

        System.out.println(departmentRepository.countAllDepartments());


    }

}
