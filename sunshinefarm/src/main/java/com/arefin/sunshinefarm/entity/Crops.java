package com.arefin.sunshinefarm.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "crops")
public class Crops {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "duration")
    private String duration;

    @Column(name = "product_code", unique = true)
    private String productCode;

    @ManyToMany
    @JoinTable(
            name = "crops_equipment",
            joinColumns = @JoinColumn(name = "crops_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    private Set<Equipment> equipment;

    @ManyToMany
    @JoinTable(
            name = "crops_insecticides",
            joinColumns = @JoinColumn(name = "crops_id"),
            inverseJoinColumns = @JoinColumn(name = "insecticides_id"))
    private Set<Insecticides> insecticides;

    @ManyToMany
    @JoinTable(
            name = "crops_pesticides",
            joinColumns = @JoinColumn(name = "crops_id"),
            inverseJoinColumns = @JoinColumn(name = "pesticides_id"))
    private Set<Pesticides> pesticides;

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

    public Set<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(Set<Equipment> equipment) {
        this.equipment = equipment;
    }

    public Set<Insecticides> getInsecticides() {
        return insecticides;
    }

    public void setInsecticides(Set<Insecticides> insecticides) {
        this.insecticides = insecticides;
    }

    public Set<Pesticides> getPesticides() {
        return pesticides;
    }

    public void setPesticides(Set<Pesticides> pesticides) {
        this.pesticides = pesticides;
    }
}
