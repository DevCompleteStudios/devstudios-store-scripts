package com.devstudios.dbu.devstudios_dbu.application.dtos.scripts;

import com.devstudios.dbu.devstudios_dbu.application.interfaces.projections.IPurchase;
import com.devstudios.dbu.devstudios_dbu.application.interfaces.projections.IScript;
import java.util.List;



public class ScriptDto implements IScript {

    private String description;
    private String name;
    private String url;
    private String image;
    private Double price;
    private Boolean isActive;
    private List<IPurchase> purchases;


    public ScriptDto(String description, String name, String url, String image, Double price, Boolean isActive,
            List<IPurchase> purchases) {
        this.description = description;
        this.name = name;
        this.url = url;
        this.image = image;
        this.price = price;
        this.isActive = isActive;
        this.purchases = purchases;
    }

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
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    public Boolean isActive() {
        return isActive;
    }
    public Boolean getIsActive() {
        return isActive;
    }
    public List<IPurchase> getPurchases() {
        return purchases;
    }
    public void setPurchases(List<IPurchase> purchases) {
        this.purchases = purchases;
    }

}
