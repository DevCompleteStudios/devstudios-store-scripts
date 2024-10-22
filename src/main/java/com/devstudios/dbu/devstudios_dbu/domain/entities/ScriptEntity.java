package com.devstudios.dbu.devstudios_dbu.domain.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="scripts")
public class ScriptEntity extends EntityBase {

    private String description;
    private String name;
    private String url;
    private String image;
    private Double price;

    @OneToMany(mappedBy = "script")
    private List<PurchasesEntity> purchases = new ArrayList<>();


    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public List<PurchasesEntity> getPurchases() {
        return purchases;
    }
    public void setPurchases(List<PurchasesEntity> purchases) {
        this.purchases = purchases;
    }

}
