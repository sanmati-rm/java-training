package com.target.training.dao;

import com.target.training.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends PagingAndSortingRepository<Product,Integer> {

    public Iterable<Product> findByDiscontinued(Integer discontinued);

    @Query("from Product where unitPrice between ?1 and ?2")
    public Iterable<Product> findProductsByPriceRange(Double min, Double max);
}
