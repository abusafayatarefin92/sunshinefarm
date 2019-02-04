package com.arefin.sunshinefarm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "crops_summary")
public class CropsSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", unique = true)
    private String productName;

    @Column(name = "product_code", unique = true)
    private String productCode;

    @Column(name = "total_quantity")
    private int totalQuantity;

    @Column(name = "sales_quantity")
    private int salesQuantity;

    @Column(name = "available_quantity")
    private int availableQuantity;

    @Column(name = "last_update")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private Date lastUpdate;

    @OneToOne
    @JoinColumn(name = "crops_id", nullable = false)
    private Crops crops;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(int salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Crops getCrops() {
        return crops;
    }

    public void setCrops(Crops crops) {
        this.crops = crops;
    }
}
