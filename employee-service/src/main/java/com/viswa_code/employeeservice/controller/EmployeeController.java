package com.viswa_code.employeeservice.controller;

import com.viswa_code.employeeservice.model.Employee;
import com.viswa_code.employeeservice.repository.EmployeeRepository;
import jakarta.websocket.server.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@RestController
@EnableDiscoveryClient
@RequestMapping("/employees")
public class EmployeeController {
private static Logger LOGGER= LoggerFactory.getLogger(EmployeeController.class);
@Autowired
EmployeeRepository repository;
@PostMapping
public Employee add(@RequestBody Employee emp) {
    LOGGER.info("Add Employee from Emp controller:" + emp);
    return repository.add(emp);
}
@GetMapping
public List<Employee> getAll(){
    LOGGER.info("Get all from EMP controller");
    return repository.findAll();
}
@GetMapping("/{id}")
public Employee findById(@PathVariable Long id){
    LOGGER.info("findById from EMP controller id:",id);
    return repository.findById(id);

}
@GetExchange("/department/{departmentId}")
public List<Employee> findByDeptId(@PathVariable Long departmentId){
LOGGER.info("Getting all employees based on dept id:",departmentId);
    return repository.findByDepartmentId(departmentId);
}
}
