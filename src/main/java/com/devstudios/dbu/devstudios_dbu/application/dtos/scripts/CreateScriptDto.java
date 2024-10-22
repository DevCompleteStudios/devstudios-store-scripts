package com.devstudios.dbu.devstudios_dbu.application.dtos.scripts;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;



public class CreateScriptDto {

    @Size(min = 4, max = 80)
    @NotEmpty
    private String name;

    @URL
    private String url;

    @Size(min = 10, max = 250)
    @NotEmpty
    private String description;

    @NotEmpty
    private Object image;

    @NotEmpty
    @Min(value = 1)
    @Max(value = 199)
    private Double price;


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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Object getImage() {
        return image;
    }
    public void setImage(Object image) {
        this.image = image;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

}
