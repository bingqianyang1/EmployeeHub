package com.example.employee_management.dao;

import com.example.employee_management.model.Employee;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

  //query method
  void deleteEmployeeById(Long id);

  //use Optional because not sure if the employee exists
  Optional<Employee> findEmployeeById(Long id);
}
