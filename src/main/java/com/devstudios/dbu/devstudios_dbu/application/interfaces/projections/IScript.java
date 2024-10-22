package com.devstudios.dbu.devstudios_dbu.application.interfaces.projections;

import java.util.List;


public interface IScript {
    public String getDescription();
    public String getName();
    public String getUrl();
    public String getImage();
    public Double getPrice();
    public Boolean isActive();
    public List<IPurchase> getPurchases();
}
