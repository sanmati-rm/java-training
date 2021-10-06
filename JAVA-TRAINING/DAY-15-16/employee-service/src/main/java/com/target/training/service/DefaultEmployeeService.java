package com.target.training.service;

import com.target.training.dao.EmployeeDao;
import com.target.training.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DefaultEmployeeService implements EmployeeService{

    @Autowired
    EmployeeDao employeeDao;

    public Employee getEmployeeById(Integer id){
        Optional<Employee> optionalEmployee = employeeDao.findById(id);
        Employee e=null;
        if(optionalEmployee.isPresent()){
            e = optionalEmployee.get();
        }
        log.debug("Employee with id {} is {} ",id,e);
        return e;
    }


    public Iterable<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }


    public Long getTotalNumberOfEmployees() {
        return employeeDao.count();
    }


    public Employee addNewEmployee(Employee e) {
        e.setEmployeeId(null);
        return employeeDao.save(e);
    }

    public Employee updateEmployee(Employee e) {
        if(e.getEmployeeId() == null){
            throw new RuntimeException("Employee must have ID for updating");
        }
        if(!employeeDao.existsById(e.getEmployeeId()))
        {
            throw new RuntimeException("Employee with ID does not exist");
        }

        return employeeDao.save(e);
    }


}
