package com.devstudios.dbu.devstudios_dbu.domain.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name="roblox_users")
public class RobloxUserEntity extends EntityBase {

    private String name;
    private String robloxId;
    private List<ScriptEntity> scripts = new ArrayList<>();


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRobloxId() {
        return robloxId;
    }
    public void setRobloxId(String robloxId) {
        this.robloxId = robloxId;
    }
    public List<ScriptEntity> getScripts() {
        return scripts;
    }
    public void setScripts(List<ScriptEntity> scripts) {
        this.scripts = scripts;
    }

}
