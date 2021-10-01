package com.target.training.controller;

import com.target.training.entity.ApiError;
import com.target.training.entity.Product;
import com.target.training.service.DefaultProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    DefaultProductService service;

    @GetMapping(path = "/{id}", produces ={"application/json","application/xml" })
    public ResponseEntity<?> handleGetProductById(@PathVariable Integer id) {
        Product p = service.getProductById(id);
        if (p != null) {
            return ResponseEntity.ok(p);
        }
        else{
            ApiError err = new ApiError(HttpStatus.NOT_FOUND,new Date(),"Product not found for id: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
        }
    }

    @GetMapping(path="/{id}",produces ="text/plain")
    public String handleGetProductByIdAsAString(@PathVariable Integer id){
        return service.getProductById(id).toString();
    }

    @GetMapping(produces="application/json")
    public Iterable<Product> handleGetAllProducts( @RequestParam(name = "_page", required = false, defaultValue = "1") Integer pageNum,
                                                   @RequestParam(name = "_limit", required = false, defaultValue = "10") Integer pageSize){
        return service.getAllProducts(pageNum,pageSize);
    }

    @GetMapping(path = "/filter", params = {"discontinued"})
    public Iterable<Product> handleGetDiscontinuedProducts(@RequestParam Boolean discontinued) {
        return discontinued ? service.getDiscontinuedProducts() : service.getNotDiscontinuedProducts();
    }

    @GetMapping(path = "/filter", params = {"min", "max"})
    public Iterable<Product> handleGetProductsInPriceRange(@RequestParam Double min, @RequestParam Double max) {
        return service.getProductsBetween(min, max);
    }

    @PostMapping(consumes="application/json",produces = "application/json")
    public ResponseEntity<Object> handleAddNewProduct(@RequestBody Product product) {
        try {
            Product p = service.addNewProduct(product);
            return ResponseEntity.ok(p);
        } catch (Exception e) {
            ApiError err = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, new Date(), e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
        }
    }

    @PutMapping(path="/{id}", consumes="application/json",produces="application/json")
    public ResponseEntity<Object> handleUpdateProduct(@PathVariable Integer id, @RequestBody Product product){
        try{
            product.setProductId(id);
            Product p = service.updateProduct(product);
            return ResponseEntity.ok(p);
        }
        catch(Exception e){
            ApiError err = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,new Date(),e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
        }
    }

    @DeleteMapping(path="/{id}",produces = "application/json")
    public ResponseEntity<Object> handleDeleteProduct(@PathVariable Integer id){
        try{
            Product p = service.deleteProduct(id);
            return ResponseEntity.ok(p);
        }
        catch(Exception e){
            ApiError err = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,new Date(),e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
        }
    }
}
