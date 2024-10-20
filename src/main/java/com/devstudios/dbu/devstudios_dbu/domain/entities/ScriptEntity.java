package com.devstudios.dbu.devstudios_dbu.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name="scripts")
public class ScriptEntity extends EntityBase {

    private Double price;
    private String description;
    private Long stock;
    private String name;


    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Long getStock() {
        return stock;
    }
    public void setStock(Long stock) {
        this.stock = stock;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
