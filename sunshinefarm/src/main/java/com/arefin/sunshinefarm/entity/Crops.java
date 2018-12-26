package com.arefin.sunshinefarm.entity;

import javax.persistence.*;

@Entity
@Table(name = "crops")
public class Crops {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private String duration;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "per_unit_selling_price")
    private Double perUnitSellingPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPerUnitSellingPrice() {
        return perUnitSellingPrice;
    }

    public void setPerUnitSellingPrice(Double perUnitSellingPrice) {
        this.perUnitSellingPrice = perUnitSellingPrice;
    }
}
