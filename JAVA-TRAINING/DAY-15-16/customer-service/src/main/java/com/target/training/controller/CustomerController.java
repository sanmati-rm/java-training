package com.target.training.controller;

import com.target.training.dao.CustomerDao;
import com.target.training.entity.Customer;
import com.target.training.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerDao dao;

    @GetMapping(produces = "application/json")
    public Iterable<Customer> handleGetAllCustomers(){
        return dao.findAll();
    }

    @GetMapping(path="/{customerId}")
    public Customer handleGetOneCustomer(@PathVariable String customerId){
        Optional<Customer> oc = dao.findById(customerId);
        if(oc.isPresent()){
            return oc.get();
        }
        throw new CustomerNotFoundException("No customer found for id: " + customerId);
    }
}
