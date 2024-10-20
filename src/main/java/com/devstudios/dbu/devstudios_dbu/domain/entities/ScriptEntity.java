package com.devstudios.dbu.devstudios_dbu.domain.entities;

import com.devstudios.dbu.devstudios_dbu.application.interfaces.enums.ScriptStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name="scripts")
public class ScriptEntity extends EntityBase {

    private String description;
    private String name;
    private String url;
    private ScriptStatus status;


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
    public ScriptStatus getStatus() {
        return status;
    }
    public void setStatus(ScriptStatus status) {
        this.status = status;
    }

}
