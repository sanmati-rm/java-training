package com.target.training.service;

import com.target.training.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    Employee getEmployeeById(Integer id);
    Iterable<Employee> getAllEmployees();
    Long getTotalNumberOfEmployees();
    Employee addNewEmployee(Employee e);
    Employee updateEmployee(Employee e);


}
