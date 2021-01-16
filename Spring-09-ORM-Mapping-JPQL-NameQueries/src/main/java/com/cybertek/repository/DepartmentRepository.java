package com.cybertek.repository;

import com.cybertek.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String> {

    @Query("select d from Department d where d.division in ?1 ")
    List<Department> getDepartmentByDivisionIn(List<String> division);


    List<Department> retrieveDepartmentByDivision(String division);

    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContains(String pattern);

    List<Department> findOzzydepartment(String division);

    List<Department> countAllDepartments();


}
