package com.viswa_code.departmentservice.controller;

import com.viswa_code.departmentservice.client.EmployeeClient;
import com.viswa_code.departmentservice.model.Department;
import com.viswa_code.departmentservice.model.Employee;
import com.viswa_code.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
private static final Logger LOGGER=
        LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    DepartmentRepository repository;

    @Autowired
    EmployeeClient employeeClient;


    @PostMapping
    public Department add(@RequestBody Department dept){
        LOGGER.info("Added Dept:"+dept);
       return repository.addDepartment(dept);
    }
    @GetMapping
    public List<Department> findAll(){
        LOGGER.info("Find all from dept:");
        return  repository.findAll();
    }
    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){
        LOGGER.info("Find by id from dept id:",id);
        return repository.findById(id);
    }
    /*public List<Department> findAllWithEmployees() {
        LOGGER.info("Find all from with-employees:");

        Employee emp=webClient.get().
                uri("http://employee-service")
                .retrieve().bodyToMono(Employee.class).block();
        List<Department>dept= repository.findAll();

        return dept;
    }*/

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees(){
        LOGGER.info("Find all from with-employees:");
        List<Department> departments=repository.findAll();
        departments.forEach(dept->dept.setEmployees(
                employeeClient.findByDeptId(dept.getId())));

        return  departments;
    }
}
