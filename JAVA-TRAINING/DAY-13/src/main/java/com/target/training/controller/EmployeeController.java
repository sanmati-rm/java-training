package com.target.training.controller;

import com.target.training.entity.ApiError;
import com.target.training.entity.Employee;
import com.target.training.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(path="/{id}", produces = "application/json")
    ResponseEntity<Object> handleGetEmployeeById(@PathVariable Integer id){
        Employee e = employeeService.getEmployeeById(id);

        if(e!=null){
            return ResponseEntity.ok(e);
        }
        else{
            ApiError err = new ApiError(HttpStatus.NOT_FOUND, new Date(), "Employee with id" +id + "not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

        }
    }

    @GetMapping(produces = "application/json")
    Iterable<Employee> handleGetAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/count")
    Long handleGetCountOfEmployees(){
        return employeeService.getTotalNumberOfEmployees();
    }

    @PostMapping(consumes = "application/json", produces="application/json")
    Employee handleNewEmployee(@RequestBody Employee e){
        return employeeService.addNewEmployee(e);
    }
}
