package com.target.training.service;

import com.target.training.dao.ProductDao;
import com.target.training.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@Service
public class DefaultProductService implements ProductService{

    @Autowired
    private ProductDao productDao;

    //Do all validations

    @Override
    public Product addNewProduct(Product product) {
        product.setProductId(null);
        return productDao.save(product);
    }

    public Product getProductById(Integer id){
        Optional<Product> ep = productDao.findById(id);
        Product p = null;
        if(ep.isPresent()){
            p = ep.get();
        }
        log.debug("Product for {} is {} ", id,p);
        return p;
    }

    @Override
    public Product updateProduct(Product product) {
        if(product.getProductId()==null){
            throw new RuntimeException("Product must have id for updating");
        }
        if(!productDao.existsById(product.getProductId())){
            throw new RuntimeException("Product has invalid id. Couldn't update");
        }
        return productDao.save(product);
    }

    @Override
    public Product deleteProduct(Integer id) {
        Optional<Product> op = productDao.findById(id);
        if(!op.isPresent()){
            throw new RuntimeException("Product has invalid id. Couldn't update");
        }

        //hard delete
        //productDao.deleteById(id);

        //soft delete
       Product p = op.get();
        p.setDiscontinued(1);
        return productDao.save(p);
    }

    @Override
    public Iterable<Product> getAllProducts(Integer pageNum, Integer pageSize) {
        PageRequest p = PageRequest.of(pageNum - 1, pageSize);
        Page<Product> result = productDao.findAll(p);

        if(result.hasContent()){
            return result.getContent();
        }
        else {
            return new ArrayList<>();
        }
    }

    @Override
    public Iterable<Product> getDiscontinuedProducts() {
        return productDao.findByDiscontinued(1);
    }

    @Override
    public Iterable<Product> getNotDiscontinuedProducts() {
        return productDao.findByDiscontinued(0);
    }

    @Override
    public Iterable<Product> getProductsBetween(Double min, Double max) {
        return productDao.findProductsByPriceRange(min, max);
    }

}
