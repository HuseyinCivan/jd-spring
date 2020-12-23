package com.cybertek;

import com.cybertek.repository.DepartmentRepository;
import com.cybertek.repository.EmployeeRepository;
import com.cybertek.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DerivedquerriesApplication {

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;


    public static void main(String[] args) {
        SpringApplication.run(DerivedquerriesApplication.class, args);
    }

    @PostConstruct
    public void testRegions() {
        System.out.println("------regions start");
        System.out.println("findByCountry : "+regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry : "+regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findByCountryContaining : "+regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainsOrderByCountry : "+regionRepository.findByCountryContainsOrderByCountry("Asia"));
        System.out.println("findTop2ByCountry : "+regionRepository.findTop2ByCountry("Canada"));

        System.out.println("------regions end");
    }

    @PostConstruct
    public void testDepartments(){

        System.out.println("---------Department start------------");

        System.out.println("findByDepartment: " + departmentRepository.findByDepartment("Toys"));
        System.out.println("findByDivision: " + departmentRepository.findByDivision("Outdoors"));
        System.out.println("findByDivisionEndingWith: " + departmentRepository.findByDivisionEndsWith("ics"));
        System.out.println("findDistinctTop3ByDivisionContaining: " + departmentRepository.findDistinctTop3ByDivisionContaining("Hea"));

        System.out.println("---------Department End------------");

    }

    @PostConstruct
    public void testEmployees(){

        System.out.println("---------Employee start------------");

        System.out.println("findByEmailIsNull: " + employeeRepository.findByEmailIsNull());
        System.out.println("findBySalaryIsGreaterThanEqualOrderBySalaryDesc: " + employeeRepository.findBySalaryIsGreaterThanEqualOrderBySalaryDesc(100000));


        System.out.println("---------Employee End------------");

    }




}
