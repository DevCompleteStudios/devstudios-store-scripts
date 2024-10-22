package com.devstudios.dbu.devstudios_dbu.application.interfaces.projections;

import com.devstudios.dbu.devstudios_dbu.application.interfaces.enums.PurchaseStatus;



public interface IPurchase {

    public IUserPreview getUser();
    public String getKey();
    public PurchaseStatus getStatus();
    public String getTransactionId();
    public Boolean getIsActive();

}
