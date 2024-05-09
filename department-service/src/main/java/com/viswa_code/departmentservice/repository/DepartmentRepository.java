package com.viswa_code.departmentservice.repository;

import com.viswa_code.departmentservice.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {
   private List<Department> departments=new ArrayList<>();

   public Department addDepartment(Department dept) {
       departments.add(dept);
       return dept;
   }
   public Department findById(Long id){
       return departments.stream()
               .filter(dept->dept.getId().equals(id))
               .findAny().orElseThrow();
   }
   public List<Department> findAll(){
       return departments;
   }
}
