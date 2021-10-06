package com.target.training.dao;

import com.target.training.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerDao extends PagingAndSortingRepository<Customer,String> {
}
