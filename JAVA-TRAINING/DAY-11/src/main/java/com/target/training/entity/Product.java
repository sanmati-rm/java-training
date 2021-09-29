package com.target.training.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product {


    @Id
    @GeneratedValue(generator = "increment")
    @Column(name="PRODUCT_ID")
    private Integer productId;
    @Column(name="PRODUCT_NAME")
    private String productName;
    @Column(name="QUANTITY_PER_UNIT")
    private String guantityPerUnit;
    @Column(name="UNIT_PRICE")
    private Double unitPrice;
    @Column(name="UNITS_IN_STOCK")
    private Integer unitsInStock;
    @Column(name="UNITS_ON_ORDER")
    private Integer unitsOnOrder;
    @Column(name="REORDER_LEVEL")
    private Integer reorderLevel;
    private Integer dicontinued;

    @ManyToOne
    @JoinColumn(name="CATEGORY_ID")
    private Category category;

    @ManyToOne
    @JoinColumn(name="SUPPLIER_ID")
    private Supplier supplier;
}
