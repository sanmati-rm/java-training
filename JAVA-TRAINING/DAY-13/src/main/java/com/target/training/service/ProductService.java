package com.target.training.service;

import com.target.training.dao.ProductDao;
import com.target.training.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface ProductService{

   //CRUD
   public Product addNewProduct(Product product);
   public Product getProductById(Integer id);
   public Product updateProduct(Product product);
   public Product deleteProduct(Integer id);


   //QUERIES
   public Iterable<Product> getAllProducts(Integer pageNum, Integer pageSize);
   public Iterable<Product> getDiscontinuedProducts();
   public Iterable<Product> getNotDiscontinuedProducts();
   public Iterable<Product> getProductsBetween(Double min, Double max);

}
