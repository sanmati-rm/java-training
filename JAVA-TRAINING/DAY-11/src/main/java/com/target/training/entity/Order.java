package com.target.training.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="ORDERS")
public class Order {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name="ORDER_ID")
    private Integer orderId;

    @Column(name="ORDER_DATE")
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Column(name="REQUIRED_DATE")
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date requiredDate;
    @Column(name="SHIPPED_DATE")
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date shippedDate;

    private Double freight;
    @Column(name="SHIP_NAME")
    private String shipName;
    @Column(name="SHIP_ADDRESS")
    private String shipAddress;
    @Column(name="SHIP_CITY")
    private String shipCity;
    @Column(name="SHIP_REGION")
    private String shipRegion;
    @Column(name="SHIP_POSTAL_CODE")
    private String shipPostalCode;
    @Column(name="SHIP_COUNTRY")
    private String shipCountry;

    @OneToOne
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customerId;

    @OneToOne
    @JoinColumn(name="EMPLOYEE_ID")
    private Employee employeeId;

    @ManyToOne
    @JoinColumn(name="SHIP_VIA")
    private Shipper shipVia;

    @OneToMany
    @JoinColumn(name="ORDER_ID")
    private List<OrderDetails> orderDetailsList;

}
