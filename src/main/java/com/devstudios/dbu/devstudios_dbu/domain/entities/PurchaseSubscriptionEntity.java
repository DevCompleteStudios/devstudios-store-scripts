package com.devstudios.dbu.devstudios_dbu.domain.entities;

import com.devstudios.dbu.devstudios_dbu.application.interfaces.enums.PurchaseStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDate;



@Entity
@Table(name = "purchases_subscriptions")
public class PurchaseSubscriptionEntity extends EntityBase {

    private LocalDate expiredAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private String key;

    @Enumerated(EnumType.STRING)
    private PurchaseStatus status;

    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private SubscriptionEntity subscription;


    @PrePersist
    public void calculateExpiredAt(){
        LocalDate currentDate = LocalDate.now();
        this.expiredAt = currentDate.plusDays(subscription.getDurationDays());
    }


    public LocalDate getExpiredAt() {
        return expiredAt;
    }
    public void setExpiredAt(LocalDate expiredAt) {
        this.expiredAt = expiredAt;
    }
    public UserEntity getUser() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public PurchaseStatus getStatus() {
        return status;
    }
    public void setStatus(PurchaseStatus status) {
        this.status = status;
    }
    public SubscriptionEntity getSubscription() {
        return subscription;
    }
    public void setSubscription(SubscriptionEntity subscription) {
        this.subscription = subscription;
    }


}