package com.target.training.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name=" ORDER_DETAILS ")
public class OrderDetails {

    @Id
    @Column(name="ORDER_ID")
    private Integer orderId;
    @Column(name="UNIT_PRICE")
    private Double unitPrice;
    private Integer quantity;
    private Double discount;

    @Column(name="PRODUCT_ID")
    private Integer productId;

}
