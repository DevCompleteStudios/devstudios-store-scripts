package com.devstudios.dbu.devstudios_dbu.application.dtos.purchases;

import com.devstudios.dbu.devstudios_dbu.application.interfaces.enums.PurchaseStatus;
import com.devstudios.dbu.devstudios_dbu.application.interfaces.projections.IPurchase;
import com.devstudios.dbu.devstudios_dbu.application.interfaces.projections.IUserPreview;



public class PurchaseDto implements IPurchase {

    private IUserPreview user;
    private String key;
    private PurchaseStatus status;
    private String transactionId;
    private Boolean isActive;
    private Long id;

    public PurchaseDto(IUserPreview user, String key, PurchaseStatus status, String transactionId, Boolean isActive, Long id) {
        this.user = user;
        this.key = key;
        this.status = status;
        this.transactionId = transactionId;
        this.isActive = isActive;
        this.id = id;
    }

    public IUserPreview getUser() {
        return user;
    }
    public String getKey() {
        return key;
    }
    public PurchaseStatus getStatus() {
        return status;
    }
    public String getTransactionId() {
        return transactionId;
    }
    public Boolean getIsActive() {
        return isActive;
    }
    public Long getId() {
        return id;
    }

}
