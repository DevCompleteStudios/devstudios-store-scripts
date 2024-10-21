package com.devstudios.dbu.devstudios_dbu.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "subscriptions")
public class SubscriptionEntity extends EntityBase {

    private String title;
    private String description;
    private Double price;
    private String image;

    private int durationDays;

    @OneToMany(mappedBy = "subscription")
    private List<PurchaseSubscriptionEntity> purchases = new ArrayList<>();


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public int getDurationDays() {
        return durationDays;
    }
    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }
    public List<PurchaseSubscriptionEntity> getPurchases() {
        return purchases;
    }
    public void setPurchases(List<PurchaseSubscriptionEntity> purchases) {
        this.purchases = purchases;
    }

}
