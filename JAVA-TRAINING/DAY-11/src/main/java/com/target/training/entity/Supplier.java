package com.target.training.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="SUPPLIERS")
public class Supplier {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name="SUPPLIER_ID")
    private Integer supplierId;
    @Column(name="COMPANY_NAME")
    private String companyName;
    @Column(name = "CONTACT_NAME")
    private String contactName;
    @Column(name="CONTACT_TITLE")
    private String contactTitle;
    private String address;
    private String city;
    private String region;

    @Column(name="POSTAL_CODE")
    private String postalCode;
    private String country;
    private String phone;
    private String fax;
    @Column(name="HOME_PAGE")
    private String homePage;

    @OneToMany
    @JoinColumn(name = "SUPPLIER_ID")
    private List<Product> productList;

    @Override
    public String toString() {
        return "Supplier{" +
                "companyName='" + companyName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactTitle='" + contactTitle + '\'' +
                '}';
    }
}
