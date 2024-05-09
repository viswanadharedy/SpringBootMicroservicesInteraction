package com.viswa_code.employeeservice.repository;

import com.viswa_code.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    public List<Employee> employees=new ArrayList<>();

    public Employee add(Employee emp){
        employees.add(emp);
        return emp;
    }
    public Employee findById(Long id){
        return  employees.stream()
                .filter(e->e.id().equals(id))
                .findFirst().orElseThrow();
        }
    public List<Employee>   findAll(){
        return employees;
    }

    public List<Employee> findByDepartmentId(Long deptId){

        return employees.stream()
                .filter(e->e.departmentId()
                .equals(deptId)).toList();

    }


}
