package com.viswa_code.departmentservice.client;

import com.viswa_code.departmentservice.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {
    @GetExchange("/employees/department/{departmentId}")
    public List<Employee> findByDeptId(@PathVariable("departmentId")
                                           Long departmentId);
}
