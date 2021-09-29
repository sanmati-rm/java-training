package com.target.training.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name="ORDER_DETAILS")
public class OrderDetails implements Serializable {

    @Id
    @Column(name="ORDER_ID")
    private Integer orderId;
    @Id
    @Column(name="PRODUCT_ID")
    private Integer productId;
    @Column(name="UNIT_PRICE")
    private Double unitPrice;
    private Integer quantity;
    private Double discount;

    @ManyToOne
    @JoinColumn(name="PRODUCT_ID",insertable = false,updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name="ORDER_ID",insertable = false, updatable = false)
    private Order order;

    public OrderDetails(Integer orderId, Integer productId){
        this.orderId=orderId;
        this.productId=productId;
    }


}
