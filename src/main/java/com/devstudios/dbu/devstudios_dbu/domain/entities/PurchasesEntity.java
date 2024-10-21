package com.devstudios.dbu.devstudios_dbu.domain.entities;



import com.devstudios.dbu.devstudios_dbu.application.interfaces.enums.PurchaseStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;




@Entity
@Table(name = "purchases")
public class PurchasesEntity extends EntityBase {

    @ManyToOne
    @JoinColumn(name = "script_id")
    private ScriptEntity script;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(unique = true)
    private String key;

    @Enumerated(EnumType.STRING)
    private PurchaseStatus status;

    @Column(unique = true)
    private String transactionId;



    public ScriptEntity getScript() {
        return script;
    }
    public void setScript(ScriptEntity script) {
        this.script = script;
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
    public String getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

}
