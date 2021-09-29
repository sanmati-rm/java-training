package com.target.training.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="SHIPPERS")
public class Shipper {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name="SHIPPER_ID")
    private Integer ShipperId;
    @Column(name="COMPANY_NAME")
    private String companyName;
    private String phone;

    @OneToMany
    @JoinColumn(name="SHIP_VIA")
    private List<Order> orderList;

    @Override
    public String toString() {
        return "Shipper{" +
                "ShipperId=" + ShipperId +
                ", companyName='" + companyName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
