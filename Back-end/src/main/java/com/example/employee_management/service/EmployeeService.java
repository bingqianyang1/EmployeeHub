package com.example.employee_management.service;

import com.example.employee_management.dao.EmployeeDao;
import com.example.employee_management.exception.UserNotFoundException;
import com.example.employee_management.model.Employee;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
  private EmployeeDao employeeDao;


  //add autowired to bring in this dependency to use this to do all of our code operations
  @Autowired
  public EmployeeService(EmployeeDao employeeDao) {
    this.employeeDao = employeeDao;
  }

  //add new employee
  public Employee addEmployee(Employee employee) {
    employee.setEmployeeCode(UUID.randomUUID().toString());
    return employeeDao.save(employee);
  }


  //get all employees
  public List<Employee> findAllEmployees() {
    return employeeDao.findAll();
  }

  //find employee by id
  public Employee findEmployeeById(Long Id) {
    return employeeDao.findEmployeeById(Id).orElseThrow(() -> new UserNotFoundException("User " +
        Id + " was not found"));
  }


  //update employee
  public Employee updateEmployee(Employee employee) {
    return employeeDao.save(employee);
  }


  //delete employee
  public void deleteEmployee(Long id) {
    employeeDao.deleteEmployeeById(id);
  }









}
