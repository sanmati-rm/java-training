package com.target.training.dao;

import com.target.training.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends PagingAndSortingRepository<Employee,Integer> {
}
