package com.arefin.sunshinefarm.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "insecticides")
public class Insecticides {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "purchase_price")
    private Double purchasePrice;

    @ManyToMany
    @JoinTable(
            name = "insecticides_crops",
            joinColumns = @JoinColumn(name = "insecticides_id"),
            inverseJoinColumns = @JoinColumn(name = "crops_id"))
    private Set<Crops> crops;

    public Set<Crops> getCrops() {
        return crops;
    }

    public void setCrops(Set<Crops> crops) {
        this.crops = crops;
    }

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

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
