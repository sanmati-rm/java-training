package com.target.training.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="ORDER_DETAILS")
public class OrderDetails {

    @Id
    @ManyToOne
    @JoinColumn(name="ORDER_ID")
    private Order orderList;
    @Column(name="UNIT_PRICE")
    private Double unitPrice;
    private Integer quantity;
    private Double discount;

//    @OneToMany
//    @JoinColumn(name="PRODUCT_ID")
//    private Integer productId;

    @Override
    public String toString() {
        return "OrderDetails{" +
                "unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", discount=" + discount +
                '}';
    }
}
